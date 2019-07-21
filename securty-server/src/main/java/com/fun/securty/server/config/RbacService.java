package com.fun.securty.server.config;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

/**
 * @author IamMr
 * @date 2019年07月21日 —— 11:08
 */

@Service
public class RbacService {

    Map<String, AntPathRequestMatcher> antPathRequestMatcherMap = Maps.newHashMap();

    public boolean hasPermission(HttpServletRequest request, Authentication auth) {
        final boolean result[] = {false};
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        authorities.forEach(o -> {
            if (o instanceof FunGrantedAuthority) {
                FunGrantedAuthority authority = (FunGrantedAuthority) o;
                System.out.println(authority);
                AntPathRequestMatcher antPathRequestMatcher = antPathRequestMatcherMap.computeIfAbsent(authority.getAuthority(), k -> {
                    if (!StringUtils.isAnyBlank(authority.getUri(), authority.getMethod())) {
                        return new AntPathRequestMatcher(authority.getUri(), authority.getMethod());
                    }
                    return null;
                });
                if (antPathRequestMatcher != null && antPathRequestMatcher.matches(request)) {
                    result[0] = true;
                }
            }
        });
        System.out.println("result[0] " + result[0]);
        return result[0];
    }

    public void clear() {
        antPathRequestMatcherMap = Maps.newHashMap();
    }
}