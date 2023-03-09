package com.reportweb.reportweb.service;

import com.reportweb.reportweb.dto.UserJoinRequestDto;
import com.reportweb.reportweb.dto.form.UserJoinRequestFormDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static com.reportweb.reportweb.domain.role.UserDepartment.*;

@SpringBootTest
@Transactional
public class UserJoinServiceTest {

    @Autowired
    UserJoinService userJoinService;

    @Autowired
    PasswordEncoder passwordEncoder;


    public UserJoinRequestDto saveJoinStay(){
        UserJoinRequestFormDto userJoinRequestFormDto = UserJoinRequestFormDto.builder()
                                                        .userName("수민")
                                                        .userId("test")
                                                        .userEmail("smpark@sherpasoft.com")
                                                        .userPasswd("1111")
                                                        .nickname("숨")
                                                        .userDepartment(LAB)
                                                        .build();
        return UserJoinRequestDto.userJoinApply(userJoinRequestFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("saveMemberTest - userJoinApply")
    public void saveMemberTest() {
        UserJoinRequestDto userJoinRequestDto = saveJoinStay();
        UserJoinRequestDto savedMember = userJoinService.saveJoinStay(userJoinRequestDto);

        Assertions.assertEquals(userJoinRequestDto.getUserEmail(), savedMember.getUserEmail());
    }

}
