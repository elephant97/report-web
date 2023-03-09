package com.reportweb.reportweb.repository;

import com.reportweb.reportweb.dto.UserJoinRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJoinRequestRepository extends JpaRepository<UserJoinRequestDto, Long> {
    UserJoinRequestDto findByUserId(String userId);
    UserJoinRequestDto findByuserEmail(String userEmail);
    UserJoinRequestDto findByNickname(String userNickname);
}
