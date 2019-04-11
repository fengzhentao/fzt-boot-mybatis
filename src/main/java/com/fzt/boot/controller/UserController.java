package com.fzt.boot.controller;

import com.fzt.boot.entity.cache.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description 测试thymeLeaf
 * @Author fengzt
 * @Date 2019/4/11
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("title", "success");
        modelAndView.addObject("user", new User(1l,"Mr.f","66666"));
        return modelAndView;
    }
}
