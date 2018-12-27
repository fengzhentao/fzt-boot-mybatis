package com.fzt.boot.entity.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 分页查询基础类
 * @Author fengzt
 * @Date 2018/12/27
 * @Version 1.0
 **/
@Data
public class BasePageQuery implements Serializable {

    private int pageIndex;

    private int pageSize;

    private String orderBy;
}
