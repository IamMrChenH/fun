package com.fun.securty.server.gateway.controller;

import com.fun.security.sdk.api.AuthApi;
import com.fun.security.sdk.vo.UserLoginVO;
import com.fun.securty.server.interfaces.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 21:06
 */
@RestController
public class AuthController implements AuthApi {

    @Autowired
    private UserClient userClient;

    @Override
    public boolean login(UserLoginVO userLoginVO) {
//        userClient.getUserByName()
        return false;
    }

    @Override
    public boolean logout() {
        throw new RuntimeException("注销错误！");
    }
}
