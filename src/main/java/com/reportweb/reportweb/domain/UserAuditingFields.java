package com.reportweb.reportweb.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class UserAuditingFields {
    @Column(nullable = false, length = 50) private String userId;
    @Column(nullable = false) private String userPasswd;

    @Column(length = 100) private String userEmail;
    @Column(length = 100) private String nickName;

}




