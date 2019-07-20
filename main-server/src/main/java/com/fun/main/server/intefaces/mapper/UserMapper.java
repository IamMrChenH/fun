package com.fun.main.server.intefaces.mapper;

import com.fun.main.sdk.vo.user.Permission;
import com.fun.main.sdk.vo.user.UserLoginDTO;
import com.fun.main.sdk.vo.user.UserVO;
import com.fun.main.server.domain.entities.Role;
import com.fun.main.server.domain.entities.User;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author IamMr
 * @date 2019年07月20日 —— 14:31
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserVO toUserVO(User user);

    List<UserVO> toUserVO(Collection<User> users);

    @Mapping(source = "roles",target = "permissions",qualifiedByName = "getPermissions")
    UserLoginDTO toUserLoginDTO(User user);

    Permission toPermission(com.fun.main.server.domain.entities.Permission permission);

    @Named("getPermissions")
    default List<Permission> getPermissions(Set<Role> roles) {
        if (roles == null) {
            return Lists.newArrayList();
        }
        Set<Permission> permissions = Sets.newHashSet();
        for (Role role : roles) {
            role.getPermissions().forEach(permission -> permissions.addAll(getPermissions(permission)));
        }
        return Lists.newArrayList(permissions);

    }

    default Set<Permission> getPermissions(com.fun.main.server.domain.entities.Permission permission) {
        Set<Permission> permissions = Sets.newHashSet();
        if (permission == null) {
            return permissions;
        }
        permissions.add(toPermission(permission));
        for (com.fun.main.server.domain.entities.Permission children : permission.getChildrens()) {
            permissions.addAll(getPermissions(children));
        }
        return permissions;
    }


}
