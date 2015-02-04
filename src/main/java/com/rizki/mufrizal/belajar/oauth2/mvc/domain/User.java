package com.rizki.mufrizal.belajar.oauth2.mvc.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rizki on 03/02/15.
 */

@Entity
@Table(name = "tb_user",
        indexes = {
                @Index(columnList = "username", name = "username")
        }
)
@JsonAutoDetect
public class User implements Serializable {

    @Id
    @Column(name = "username", length = 30, unique = true)
    private String username;

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "enable", columnDefinition = "TINYINT")
    private boolean enable;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Set<UserRole> userRoles = new HashSet<UserRole>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
