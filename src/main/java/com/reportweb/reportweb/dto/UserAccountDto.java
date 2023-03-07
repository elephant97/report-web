package com.reportweb.reportweb.dto;

import com.reportweb.reportweb.domain.role.UserDepartment;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserAccountDto extends UserJoinRequestDto {
    @Enumerated(EnumType.STRING)
    private UserDepartment userAuthority;
}
