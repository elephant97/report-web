package com.reportweb.reportweb.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Table(indexes = {
        @Index(columnList = "userId", unique = true),
        @Index(columnList = "userPasswd", unique = true),
        @Index(columnList = "userEmail", unique = true)
})
@Entity
public class UserAccount extends UserAuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//key

    @Setter @OneToOne(optional = false) private UserStayConnected userStay;//승인 대기 User

    @Setter @Column(nullable = false) private String userAuthority;
    @Setter @Column(nullable = false) private String userDepartment;

    protected UserAccount(){}

    private UserAccount(UserStayConnected userStay, String userAuthority, String userDepartment){
        this.userStay = userStay;
        this.userAuthority = userAuthority;
        this.userDepartment = userDepartment;
    }

    public static UserAccount of(UserStayConnected userStay, String userAuthority, String userDepartment){
        return new UserAccount(userStay, userAuthority, userDepartment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return id != null && id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
