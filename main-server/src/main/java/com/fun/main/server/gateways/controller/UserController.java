package com.fun.main.server.gateways.controller;

import com.fun.main.sdk.api.UserApi;
import com.fun.main.sdk.vo.user.UserLoginDTO;
import com.fun.main.sdk.vo.user.UserVO;
import com.fun.main.server.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author IamMr
 * @date 2019年07月16日 —— 23:24
 */
@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public UserVO getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @Override
    public List<UserVO> getUserListPage() {
        return userService.findAll();
    }

    @Override
    public UserLoginDTO getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }
}
