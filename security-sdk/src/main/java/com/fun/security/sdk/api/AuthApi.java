package com.fun.security.sdk.api;

import com.fun.security.sdk.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 20:59
 */
@Api(value = "auth", tags = "登录和权限接口")
@RequestMapping("/v1/auth")
public interface AuthApi {

    @ApiOperation(value = "登录接口", notes = "登录接口啦！")
    @PostMapping("login")
    boolean login(@RequestBody UserLoginVO userLoginVO);


    @ApiOperation(value = "注销", notes = "登录接口啦！")
    @PostMapping("logout")
    boolean logout();

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息！")
    @GetMapping("info")
    String getInfo();


    @ApiOperation(value = "获取用户信息", notes = "获取用户信息！")
    @GetMapping("user_id")
    Long getUserId();

}
