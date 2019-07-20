package com.fun.main.server.domain.entities;

import com.fun.base.entities.BaseAuditEntity;
import com.fun.main.server.repository.RoleRepository;
import lombok.Getter;
import lombok.Setter;
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
public class Role extends BaseAuditEntity<RoleRepository, Role> {

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色标识
     */
    @Column(unique = true)
    private String code;

    /**
     * 备注 就是说明
     */
    private String remark;

    /**
     * 本角色的用户
     */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    /**
     * 本角色的权限
     */
    @ManyToMany
    private Set<Permission> permissions;


    @Override
    public Role insert() {
        return getRepository().save(this);
    }

    @Override
    public Role update() {
        return null;
    }

    @Override
    public Class getRepositoryClass() {
        return RoleRepository.class;
    }
}
