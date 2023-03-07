package com.reportweb.reportweb.controller;

import com.reportweb.reportweb.dto.UserJoinRequestDto;
import com.reportweb.reportweb.dto.form.UserJoinRequestFormDto;
import com.reportweb.reportweb.service.UserJoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping(value = "/login")
@Controller
public class UserJoinController {

    private final UserJoinService userJoinService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/join-user")
    public String joinForm(Model map)
    {
        map.addAttribute("UserJoinRequestFormDto", new UserJoinRequestFormDto());
        return "join/join-form";
    }

    @PostMapping(value = "join-user")
    public String joinForm(@Valid UserJoinRequestFormDto userJoinRequestFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "join/join-form";
        }
        try {
            UserJoinRequestDto userJoinRequestDto = UserJoinRequestDto.userJoinApply(userJoinRequestFormDto, passwordEncoder);
            userJoinService.saveJoinStay(userJoinRequestDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "join/join-form";
        }
        return "redirect:/";
    }
}
