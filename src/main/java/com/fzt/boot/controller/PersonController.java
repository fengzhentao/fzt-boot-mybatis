package com.fzt.boot.controller;

import com.fzt.boot.base.PageBean;
import com.fzt.boot.entity.Person;
import com.fzt.boot.service.PersonService;
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
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person/page")
    private PageBean<Person> findPersonPage(@RequestParam int pageIndex,
                                            @RequestParam int pageSize,
                                            @RequestParam String name) {
        Person person = new Person();
        person.setName(name);
        PageBean<Person> personPage = personService.findPage(pageIndex,pageSize,person);
        return personPage;
    }
}
