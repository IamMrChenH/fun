package com.fun.securty.server.gateway.controller;

import com.fun.security.sdk.api.AuthApi;
import com.fun.security.sdk.vo.UserLoginVO;
import com.fun.securty.server.config.FunUser;
import com.fun.securty.server.interfaces.client.UserClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
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
        return false;
    }

    @Override
    public boolean logout() {
        throw new RuntimeException("注销错误！");
    }

    @Override
    public String getInfo() {
        return "登录成功！" + getUserId();
    }

    @Override
    public Long getUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof FunUser) {
            return ((FunUser) principal).getUserId();
        }
        throw new RuntimeException("id不存在");
    }

    @ApiOperation(hidden = true, value = "登录页面", notes = "为了返回401，无需测试")
    @GetMapping(value = "/login_page")
    public ResponseEntity<Void> logoutPage() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
