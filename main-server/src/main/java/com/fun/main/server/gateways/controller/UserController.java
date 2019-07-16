package com.fun.main.server.gateways.controller;

import com.fun.main.sdk.api.UserApi;
import com.fun.main.sdk.vo.user.UserVO;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IamMr
 * @date 2019年07月16日 —— 23:24
 */
@RestController
public class UserController implements UserApi {

    @Override
    public UserVO getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserVO> getUserListPage() {
        ArrayList<UserVO> userVOS = Lists.newArrayList();
        userVOS.add(new UserVO(1L));
        return userVOS;
    }

    @Override
    public UserVO getUserByName(String name) {
        return null;
    }
}
