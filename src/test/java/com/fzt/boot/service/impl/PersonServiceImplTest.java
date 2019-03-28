package com.fzt.boot.service.impl;
import java.util.Date;
import java.util.List;

import com.fzt.boot.base.PageBean;
import com.fzt.boot.entity.Person;
import com.fzt.boot.entity.query.BasePageQuery;
import com.fzt.boot.entity.query.PersonQuery;
import com.fzt.boot.entity.vo.PersonVo;
import com.fzt.boot.mapper.PersonMapper;
import com.fzt.boot.service.PersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonMapper personMapper;

    @Test
    public void save() {
        Person person = new Person();
        person.setName("小红");
        person.setSex((byte)0);
        person.setMoney(0L);
        person.setPrice(0.0D);
        person.setCount(0.0F);
        person.setCreateTime(new Date());
        person.setUpdateTime(new Date());
        person.setDisabled(false);

        personService.save(person);
    }

    @Test
    public void deleteById() {
        System.out.println(personService.deleteById(1l));
    }

    @Test
    public void update() {
        Person person = personService.getById(4l);
        person.setName("小王");
        personService.update(person);
    }

    @Test
    public void getById() {
        System.out.println(personService.getById(2l));
    }

    @Test
    public void findAll() {
        System.out.println(personService.findAll());
    }

    @Test
    public void findPage() {
        PageInfo<Person> pageBean = personService.findPage(1,2,new Person());
        System.out.println(pageBean.toString());
        List<Person>  personList = pageBean.getList();
        System.out.println(personList);
    }

    @Test
    public void findPersonBookPage() {
        PersonQuery query = new PersonQuery();
        PageHelper.startPage(0, 4);
        List<PersonVo> personVoList = personMapper.findPersonBooks(query);
        PageInfo<PersonVo> pageInfo = new PageInfo<>(personVoList);
        System.out.println(pageInfo.getList());
    }
}