package com.fun.securty.server.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 22:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunGrantedAuthority implements GrantedAuthority {

    private String uri;

    private String method;

    private String code;

    @Override
    public String getAuthority() {
        return code;
    }

}
