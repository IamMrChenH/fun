package com.fun.main.server.intefaces.mapper;

import com.fun.main.sdk.vo.user.UserVO;
import com.fun.main.server.domain.User;
import org.mapstruct.Mapper;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 14:31
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserVO toUserVO(User user);

}
