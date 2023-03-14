package com.reportweb.reportweb.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.reportweb.reportweb.dto.UserJoinRequestDto;
import com.reportweb.reportweb.repository.UserJoinRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserJoinService {
    private final UserJoinRequestRepository userJoinRequestRepository;

    public UserJoinRequestDto saveJoinStay(UserJoinRequestDto userJoinRequestDto){
        validateDuplicateUser(userJoinRequestDto);

        return userJoinRequestRepository.save(userJoinRequestDto);
    }

    private void validateDuplicateUser(UserJoinRequestDto userJoinRequestDto){
        if(userJoinRequestRepository.findByUserId(userJoinRequestDto.getUserId()) != null){
            System.out.println("#########중복된 ID 입니다.");
            throw new IllegalStateException("중복된 ID 입니다.");
        }
        if(userJoinRequestRepository.findByuserEmail(userJoinRequestDto.getUserEmail())!= null){
            System.out.println("#########중복된 Email 입니다.");
            throw new IllegalStateException("중복된 Email 입니다.");
        }
        if(userJoinRequestRepository.findByNickname(userJoinRequestDto.getNickname())!= null){
            System.out.println("#########중복된 Nickname 입니다.");
            throw new IllegalStateException("중복된 Nickname 입니다.");
        }
    }

}
