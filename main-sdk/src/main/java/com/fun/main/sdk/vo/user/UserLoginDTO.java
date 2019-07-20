package com.fun.main.sdk.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.List;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 20:15
 */
@ApiModel("用户参数")
@Data
public class UserLoginDTO {

    @ApiParam(name = "用户id")
    private Long id;
    @ApiParam(name = "用户登录名")
    private String userName;
    @ApiParam(name = "用户密码")
    private String password;
    @ApiParam(name = "用户权限")
    private List<Permission> permissions;

}
