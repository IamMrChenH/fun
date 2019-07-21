package com.fun.securty.server.gateway.client;

import com.fun.main.sdk.api.UserApi;
import com.fun.main.sdk.vo.user.UserLoginDTO;
import com.fun.securty.server.interfaces.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户接口 中间层 实现类
 *
 * @author IamMr
 * @date 2019年07月20日 —— 21:37
 */
@Service
public class SecurityUserClientImpl implements UserClient {

    @Autowired
    private UserApi userApi;

    @Override
    public UserLoginDTO getUserByName(String name) {
        UserLoginDTO userLoginDTO = userApi.getUserByName(name);
        if (userLoginDTO == null) {
            return null;
        }
        return userLoginDTO;
    }
}
