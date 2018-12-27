package com.fzt.boot.base;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description 通用service实现
 * @Author fengzt
 * @Date 2018/12/26
 * @Version 1.0
 **/
public class BaseServiceImpl<T,ID> implements BaseService<T,ID> {

    @Autowired
    private MyMapper<T> mapper;

    @Override
    public int save(T model) {
        return mapper.insertSelective(model);
    }

    @Override
    public int saveBatch(List<T> models) {
        return mapper.insertList(models);
    }

    @Override
    public int deleteById(ID id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByIds(String ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    public int update(T model) {
        return mapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public T getById(ID id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    @Override
    public List<T> findAll(T model) {
        return mapper.select(model);
    }

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public PageBean<T> findPage(int pageIndex, int pageSize, T model) {
          PageHelper.startPage(pageIndex,pageSize);
          List<T> modelList = mapper.select(model);
          int count = mapper.selectCount(model);
          PageBean<T> pageBean = new PageBean<>(pageIndex,pageSize,count);
          pageBean.setItems(modelList);
        return pageBean;
    }

}
