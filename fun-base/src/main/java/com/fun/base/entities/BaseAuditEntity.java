//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.fun.base.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.data.jpa.repository.JpaRepository;

@MappedSuperclass
public abstract class BaseAuditEntity<R extends JpaRepository, E extends BaseAuditEntity> extends AbstractAuditEntity<R, E> {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    public BaseAuditEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
