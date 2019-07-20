package com.fun.security.sdk.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 21:07
 */
@ApiModel("用户登录参数")
@Data
public class UserLoginVO {

    @ApiParam(name = "用户登录名")
    private String userName;
    @ApiParam(name = "用户密码")
    private String password;
}
