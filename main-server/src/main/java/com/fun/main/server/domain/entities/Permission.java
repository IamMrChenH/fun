package com.fun.main.server.domain.entities;

import com.fun.base.entities.BaseAuditEntity;
import com.fun.main.server.repository.PermissionRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
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
public class Permission extends BaseAuditEntity<PermissionRepository, Permission> {

    /**
     * 权限名称
     */
    private String name;

    /**
     * uri地址
     */
    private String uri;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 唯一值
     */
    @Column(unique = true)
    private String code;

    /**
     * 是否基础权限
     */
    private Boolean base;

    /**
     * 备注
     */
    private String remark;

    /**
     * 父权限
     */
    @ManyToOne
    private Permission parent;

    /**
     * 子权限
     */
    @OneToMany(mappedBy = "parent")
    private Set<Permission> childrens;

    /**
     * 权限关联的角色
     */
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;


    @Override
    public Permission insert() {
        return getRepository().save(this);
    }

    @Override
    public Permission update() {
        return null;
    }

    @Override
    public Class getRepositoryClass() {
        return PermissionRepository.class;
    }
}
