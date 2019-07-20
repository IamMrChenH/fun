package com.fun.main.sdk.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author IamMr
 * @date 2019年07月16日 —— 23:12
 */
@ApiModel("用户参数")
@Data
public class UserVO {

    @ApiParam
    private Long id;

}
