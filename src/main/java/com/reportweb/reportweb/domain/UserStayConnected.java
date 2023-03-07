package com.reportweb.reportweb.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Table(indexes = {
        @Index(columnList = "userId", unique = true),
        @Index(columnList = "userPasswd", unique = true),
        @Index(columnList = "userEmail", unique = true)
})
@Entity
public class UserStayConnected extends UserAuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//key
    @Setter private String memo;

    protected UserStayConnected(){}

    private UserStayConnected(String memo){
        this.memo = memo;
    }

    public static UserStayConnected of(String memo){
        return new UserStayConnected(memo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserStayConnected that = (UserStayConnected) o;
        return id != null && id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


