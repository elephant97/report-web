package com.reportweb.reportweb.dto;

import com.reportweb.reportweb.domain.role.UserRole;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserAccountDto extends UserJoinRequestDto {
    @Enumerated(EnumType.STRING)
    private UserRole userAuthority;
}
