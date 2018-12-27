package com.fzt.boot.entity.query;

import lombok.Data;

/**
 * @Description 用户查询条件
 * @Author fengzt
 * @Date 2018/12/27
 * @Version 1.0
 **/
@Data
public class PersonQuery extends BasePageQuery {

    private String name;
}
