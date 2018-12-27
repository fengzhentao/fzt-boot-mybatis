package com.fzt.boot.base;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @Description 通用dao接口
 * @Author fengzt
 * @Date 2018/12/26
 * @Version 1.0
 **/
public interface MyMapper<T> extends BaseMapper<T>,IdsMapper<T>,InsertListMapper<T> {
}
