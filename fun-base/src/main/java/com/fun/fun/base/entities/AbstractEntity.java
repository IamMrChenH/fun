//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.fun.fun.base.entities;

import com.fun.fun.base.exceptions.BaseException;
import com.fun.fun.base.utils.ApplicationContextUtils;

import java.util.concurrent.ConcurrentHashMap;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

@MappedSuperclass
public abstract class AbstractEntity<R extends JpaRepository, E extends AbstractEntity> implements Entity {
    @Transient
    private Object repository;
    private static final ConcurrentHashMap<Class, Object> CACHE = new ConcurrentHashMap();

    public AbstractEntity() {
    }

    public R getRepository() {
        if (this.repository != null) {
            return (R) this.repository;
        } else {
            this.repository = CACHE.get(this.getRepositoryClass());
            if (this.repository != null) {
                return (R) this.repository;
            } else {
                ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
                if (applicationContext == null) {
                    return null;
                } else {
                    synchronized (CACHE) {
                        Object bean = applicationContext.getBean(this.getRepositoryClass());
                        this.repository = bean;
                        CACHE.put(this.getRepositoryClass(), bean);
                    }

                    return (R) this.repository;
                }
            }
        }
    }

    public int hashCode() {
        return this.getId() != null ? this.getId().hashCode() : super.hashCode();
    }

    public boolean equals(Object o) {
        if (this.getId() != null && o instanceof AbstractEntity) {
            AbstractEntity baseEntity = (AbstractEntity) o;
            return this.getId().equals(baseEntity.getId());
        } else {
            return super.equals(o);
        }
    }

    public String toString() {
        return super.toString() + " id= " + this.getId();
    }

    public void idMustNull() {
        if (this.getId() != null) {
            throw new BaseException("ID.MUST.NULL");
        }
    }

    public void idNotNull() {
        if (this.getId() == null) {
            throw new BaseException("ID.MUST.NOT.NULL");
        }
    }

    public E findOne() {
        return this.getId() == null ? null : (E) this.getRepository().findOne(this.getId());
    }

    public E findOneAbsolute() {
        this.idNotNull();
        E entity = (E) this.getRepository().findOne(this.getId());
        if (entity == null) {
            throw new BaseException(this.dataNotExistMessage());
        } else {
            return entity;
        }
    }

    public E findOneOrInsert() {
        this.idNotNull();
        E entity = this.findOne();
        if (entity == null) {
            entity = this.insert();
        }

        return entity;
    }

    public String dataNotExistMessage() {
        return "DATA.NOT.EXIST";
    }

    public void delete() {
        this.idNotNull();
        this.getRepository().delete(this.getId());
    }

    public E save() {
        AbstractEntity entity = this.findOne();
        if (entity == null) {
            entity = this.insert();
        } else {
            entity = this.update();
        }
        return (E) entity;
    }

    public abstract E insert();

    public abstract E update();
}
