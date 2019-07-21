package com.fun.securty.server.config;

import com.fun.main.sdk.vo.user.UserLoginDTO;
import com.fun.securty.server.interfaces.client.UserClient;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 21:55
 */
@Service
public class FunUserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserClient userClient;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserLoginDTO userLoginDTO = userClient.getUserByName(name);
        if (userLoginDTO == null) {
            throw new RuntimeException("用户不存在！");
        }
        List<FunGrantedAuthority> authorities = Lists.newArrayList();
        if (userLoginDTO.getPermissions() != null) {
            List<FunGrantedAuthority> collect = userLoginDTO.getPermissions()
                    .stream()
                    .map(permission ->
                            new FunGrantedAuthority(
                                    permission.getUri(),
                                    permission.getMethod(),
                                    permission.getCode()))
                    .collect(Collectors.toList());
            authorities.addAll(collect);
        }
        String encode = passwordEncoder.encode(userLoginDTO.getPassword());
        return new FunUser(name, encode, authorities);
    }
}
