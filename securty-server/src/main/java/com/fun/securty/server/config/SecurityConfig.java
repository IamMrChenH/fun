package com.fun.securty.server.config;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

/**
 * 安全
 *
 * @author IamMr
 * @date 2019年07月20日 —— 21:53
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        ArrayList<String> permitMatcherList = Lists.newArrayList();
        permitMatcherList.add("/v1/auth/**");
        permitMatcherList.add("/v1/auth/**");

        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(permitMatcherList.toArray(new String[permitMatcherList.size()])).permitAll()
                .anyRequest().authenticated()
                .anyRequest().access("@rbacService.hasPermission(request,authentication)")
                .and()
                .formLogin()
                .and().logout()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/**/*.js", "/**/*.css", "/**/*.html", "/**/*.ico", "/webjars/**", "/swagger-resources/**", "/v2/api-docs");

    }

}
