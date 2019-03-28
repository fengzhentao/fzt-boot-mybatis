package com.fzt.boot.service;

import com.fzt.boot.base.BaseService;
import com.fzt.boot.entity.Person;
import com.fzt.boot.entity.query.PersonQuery;
import com.fzt.boot.entity.vo.PersonVo;
import com.github.pagehelper.PageInfo;

/**
 * @Description 用户service
 * @Author fengzt
 * @Date 2018/12/26
 * @Version 1.0
 **/
public interface PersonService extends BaseService<Person,Long> {

    public PageInfo<PersonVo> findPersonBooks(PersonQuery query);
}
