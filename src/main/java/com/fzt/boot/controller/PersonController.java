package com.fzt.boot.controller;

import com.fzt.boot.entity.Person;
import com.fzt.boot.entity.query.PersonQuery;
import com.fzt.boot.entity.vo.PersonVo;
import com.fzt.boot.service.PersonService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 用户API
 * @Author fengzt
 * @Date 2018/12/26
 * @Version 1.0
 **/
@Api(description = "用户")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person/page")
    public PageInfo<Person> findPerson(@RequestParam int pageIndex,
                                       @RequestParam int pageSize,
                                       @RequestParam String name) {
        Person person = new Person();
        person.setName(name.isEmpty() ? null : name);
        PageInfo<Person> personPage = personService.findPage(pageIndex, pageSize, person);
        return personPage;
    }

    @GetMapping("/person/books/page")
    public PageInfo<PersonVo> findPersonBooks(@RequestParam int pageIndex,
                                              @RequestParam int pageSize,
                                              @RequestParam String name) {
        PersonQuery query = new PersonQuery();
        query.setPageIndex(pageIndex);
        query.setPageSize(pageSize);
        query.setName(name);
        PageInfo<PersonVo> pageInfo = personService.findPersonBooks(query);
        return pageInfo;
    }
}
