package com.github.spring.sqldemo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageEntity implements Serializable {
    private transient int pageSize = 10;
    private transient int pageNum = 1;

    private transient String sortField;
    private transient String sortOrder;

    /**
     * 查询用字段
     */
    private transient String querycreatetime;

    /**
     * 查询用字段
     */
    private transient String querycreatetime2;

}
