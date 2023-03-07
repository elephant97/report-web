package com.reportweb.reportweb.dto;

import com.reportweb.reportweb.domain.role.UserRole;
import com.reportweb.reportweb.dto.form.UserJoinRequestFormDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Table(name = "user_join_stay")
@Entity
public class UserJoinRequestDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userCode")
    private Long userCode;

    private String userName;
    @Column(unique = true)
    private String userId;

    private String userPasswd;

    @Column(unique = true)
    private String userEmail;
    @Column(unique = true)
    private String nickName;


    @Builder
    public UserJoinRequestDto(String userName, String userId, String userPasswd, String userEmail, String nickName) {
        this.userName = userName;
        this.userId = userId;
        this.userPasswd = userPasswd;
        this.userEmail = userEmail;
        this.nickName = nickName;
    }
    public static UserJoinRequestDto userJoinApply(UserJoinRequestFormDto userJoinFormDto, PasswordEncoder passwordEncoder) {
        UserJoinRequestDto userJoin = UserJoinRequestDto.builder()
                .userName(userJoinFormDto.getUserName())
                .userEmail(userJoinFormDto.getUserEmail())
                .userId(userJoinFormDto.getUserId())
                .userPasswd(passwordEncoder.encode(userJoinFormDto.getUserPasswd()))  //암호화처리
                .build();
        return userJoin;
    }

}
