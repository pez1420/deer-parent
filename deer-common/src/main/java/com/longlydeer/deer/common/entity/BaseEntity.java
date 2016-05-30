package com.longlydeer.deer.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础类
 *
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1054447808965752862L;

    private Long id;
    private Date createDate;
    private Date modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (this == o)
            return true;

        if (!BaseEntity.class.isAssignableFrom(o.getClass()))
            return false;

        BaseEntity that = (BaseEntity) o;

        return getId() != null ? getId().equals(that.getId()) : false;

    }

    @Override
    public int hashCode() {
        int i = 17;
        i += (getId() == null ? 0 : getId().hashCode() * 31);
        return i;
    }
}
