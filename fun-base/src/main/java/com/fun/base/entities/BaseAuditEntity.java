//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.fun.base.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.repository.JpaRepository;

@MappedSuperclass
@Getter
@Setter
@Accessors(chain = true)
public abstract class BaseAuditEntity<R extends JpaRepository, E extends BaseAuditEntity> extends AbstractAuditEntity<R, E> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
