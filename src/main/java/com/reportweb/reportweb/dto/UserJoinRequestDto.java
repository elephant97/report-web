package com.reportweb.reportweb.dto;

import com.reportweb.reportweb.domain.role.UserDepartment;
import com.reportweb.reportweb.dto.form.UserJoinRequestFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@NoArgsConstructor
@Getter
@Table(name = "user_join_stay")
@Entity
public class UserJoinRequestDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userCode")
    private Long userCode;


    private String userName;
    @Column(unique = true)
    private String userId;

    private String userPasswd;

    @Column(unique = true)
    private String userEmail;
    @Column(unique = true)
    private String nickname;

    private UserDepartment userDepartment;


    @Builder
    public UserJoinRequestDto(String userName, String userId, String userPasswd, String userEmail, String nickname, UserDepartment userDepartment) {
        this.userName = userName;
        this.userId = userId;
        this.userPasswd = userPasswd;
        this.userEmail = userEmail;
        this.nickname = nickname;
        this.userDepartment = userDepartment;
    }
    public static UserJoinRequestDto userJoinApply(UserJoinRequestFormDto userJoinFormDto, PasswordEncoder passwordEncoder) {
        System.out.println("################"+userJoinFormDto.getUserPasswd());
        UserJoinRequestDto userJoin = UserJoinRequestDto.builder()
                .userName(userJoinFormDto.getUserName())
                .userEmail(userJoinFormDto.getUserEmail())
                .userId(userJoinFormDto.getUserId())
                .nickname(userJoinFormDto.getNickname())
                .userDepartment(userJoinFormDto.getUserDepartment())
                .userPasswd(passwordEncoder.encode(userJoinFormDto.getUserPasswd()))  //암호화처리
                .build();
        return userJoin;
    }

}
