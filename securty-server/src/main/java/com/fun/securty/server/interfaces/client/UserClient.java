package com.fun.securty.server.interfaces.client;

import com.fun.main.sdk.vo.user.UserLoginDTO;

/**
 * 用户接口 中间层
 *
 * @author IamMr
 * @date 2019年07月20日 —— 21:35
 */
public interface UserClient {

    UserLoginDTO getUserByName(String name);

}
