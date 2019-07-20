package com.fun.main.sdk.api;

import com.fun.main.sdk.vo.user.UserVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author IamMr
 * @date 2019年07月16日 —— 23:11
 */
@Api(value = "user",tags = "用户管理接口")
@RequestMapping("/v1/user")
public interface UserApi {

    @ApiOperation(value = "根据id获取用户信息", notes = "根据url的id获取用户信息")
    @GetMapping("{id}")
    UserVO getUserById(@PathVariable("id") @ApiParam(name = "id", value = "用户ID", required = true) Long id);

    @ApiOperation(value = "获取用户列表", notes = "获取用户的列表")
    @GetMapping
    List<UserVO> getUserListPage();

    @ApiOperation(value = "根据名称获取用户信息", notes = "根据名称获取用户信息")
    @GetMapping("username/{name}")
    UserVO getUserByName(@PathVariable("name") @ApiParam(name = "name", value = "用户登录名", required = true) String name);
}
