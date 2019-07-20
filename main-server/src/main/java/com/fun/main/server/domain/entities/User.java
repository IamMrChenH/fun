package com.fun.main.server.domain.entities;

import com.fun.base.entities.BaseAuditEntity;
import com.fun.main.server.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * @author chenh
 * @date 2019-07-19
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class User extends BaseAuditEntity<UserRepository, User> {

    /**
     * 登录名
     */
    @Column(unique = true)
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户的角色
     */
    @ManyToMany
    private Set<Role> roles;

    @Override
    public User insert() {
        return getRepository().save(this);
    }

    @Override
    public User update() {
        return null;
    }

    @Override
    public Class getRepositoryClass() {
        return UserRepository.class;
    }

    public static User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        return user.findOneAbsolute();
    }


}
