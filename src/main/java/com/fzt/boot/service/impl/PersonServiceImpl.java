package com.fzt.boot.service.impl;

import com.fzt.boot.base.BaseServiceImpl;
import com.fzt.boot.entity.Person;
import com.fzt.boot.entity.query.PersonQuery;
import com.fzt.boot.entity.vo.PersonVo;
import com.fzt.boot.mapper.PersonMapper;
import com.fzt.boot.service.PersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description 用户service实现
 * @Author fengzt
 * @Date 2018/12/26
 * @Version 1.0
 **/
@Service
public class PersonServiceImpl extends BaseServiceImpl<Person,Long> implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    @Cacheable(value = "personBookCaches", key = "'personBooks' + #p0")
    public PageInfo<PersonVo> findPersonBooks(PersonQuery query) {
        PageHelper.startPage(query.getPageIndex(), query.getPageSize());
        return new PageInfo<>(personMapper.findPersonBooks(query));
    }
}
