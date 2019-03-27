package com.example.skeleton.common.basicMethod;

import com.example.skeleton.common.Pager;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BasicDTO {
    /**
     * 代表删除
     */
    public static final int DEL = 0;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private Pager pager;
    public static int getDEL() {
        return DEL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
