package com.reportweb.reportweb.dto.form;

import com.reportweb.reportweb.domain.role.UserDepartment;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Getter
public class UserJoinRequestFormDto {


    @NotBlank(message = "이름은 필수 입력 값 입니다.")
    private String userName;
    @NotEmpty(message = "ID는 필수 입력 값 입니다.")
    private String userId;

    @NotEmpty(message = "PASSWORD는 필수 입력 값 입니다.")
    @Length(min = 8, max = 20, message = "비밀번호는 8자 이상, 20자 이하로 입력해주세요.")
    private String userPasswd;

    @NotEmpty(message = "EMAIL는 필수 입력 값 입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String userEmail;
    @NotEmpty(message = "NICKNAME은 필수 입력 값 입니다.")
    private String nickname;

    @NotNull
    private UserDepartment userDepartment;

    @Builder
    public UserJoinRequestFormDto(String userName, String userId, String userPasswd, String userEmail, String nickname, UserDepartment userDepartment) {
        this.userName = userName;
        this.userId = userId;
        this.userPasswd = userPasswd;
        this.userEmail = userEmail;
        this.nickname = nickname;
        this.userDepartment = userDepartment;
    }
}
