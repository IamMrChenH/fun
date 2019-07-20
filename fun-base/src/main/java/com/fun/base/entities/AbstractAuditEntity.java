//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.fun.base.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.JpaRepository;

@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public abstract class AbstractAuditEntity<R extends JpaRepository, E extends AbstractAuditEntity> extends AbstractEntity<R, E> {
    @Column(
        updatable = false
    )
    @CreatedDate
    private Date createTime;
    @Column
    @LastModifiedDate
    private Date lastModifiedTime;
    @CreatedBy
    @Column
    private String createBy;
    @Column
    @LastModifiedBy
    private String lastModifiedBy;

    public AbstractAuditEntity() {
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
