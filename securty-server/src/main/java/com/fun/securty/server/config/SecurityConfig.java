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
        permitMatcherList.add("/auth/**");

        http.csrf().disable();
        http
                .formLogin()
                //.loginPage("/v1/auth/login_page")
                //指定登录接口 地址：端口/auth/login
                .loginProcessingUrl("/auth/login")
                //指定登录成功后，每次访问的地址
                .defaultSuccessUrl("/v1/auth/info", true)
                .and()
                .logout()
                .and()
                .authorizeRequests()
                //允许不用验证的接口
                .antMatchers(permitMatcherList.toArray(new String[permitMatcherList.size()])).permitAll()
                //下面所有接口需要通过验证才可以访问
                .anyRequest().authenticated()
                //这是权限验证
                .anyRequest().access("@rbacService.hasPermission(request,authentication)");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/**/*.js", "/**/*.css", "/**/*.html", "/**/*.ico", "/webjars/**", "/swagger-resources/**", "/v2/api-docs");

    }

}
