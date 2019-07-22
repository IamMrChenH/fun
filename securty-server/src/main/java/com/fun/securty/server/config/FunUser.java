package com.fun.securty.server.config;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 21:48
 */
@Getter
public class FunUser extends User {

    /**
     * 用户id
     */
    private Long userId;

    public FunUser(Long userId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
    }
}
