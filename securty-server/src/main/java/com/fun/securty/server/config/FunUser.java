package com.fun.securty.server.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 21:48
 */
public class FunUser extends User {
    public FunUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
