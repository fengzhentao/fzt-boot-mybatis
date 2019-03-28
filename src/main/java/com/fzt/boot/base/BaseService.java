package com.fzt.boot.base;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description 通用service接口
 * @Author fengzt
 * @Date 2018/12/26
 * @Version 1.0
 **/
public interface BaseService<T,ID> {

    int save(T model);

    int saveBatch(List<T> models);

    int deleteById(ID id);

    int deleteByIds(String ids);

    int update(T model);

    T getById(ID id);

    List<T> findByIds(String ids);

    List<T> findAll(T model);

    List<T> findAll();

    PageInfo<T> findPage(int pageIndex, int pageSize, T model);

}
