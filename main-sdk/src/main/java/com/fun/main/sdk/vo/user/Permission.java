package com.fun.main.sdk.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 20:18
 */
@ApiModel("用户权限")
@Data
public class Permission {

    @ApiParam(name = "权限id")
    private Long id;
    @ApiParam(name = "权限名称")
    private String name;
    @ApiParam(name = "uri地址")
    private String uri;
    @ApiParam(name = "请求方式")
    private String method;
    @ApiParam(name = "code唯一值")
    private String code;
}

