package com.fzt.boot.service.impl;

import com.fzt.boot.entity.cache.User;
import com.fzt.boot.service.RedisCacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Description 测试redis
 * @Author fengzt
 * @Date 2019/4/8
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisLettuceTest {

    private static final Logger log = LoggerFactory.getLogger(RedisLettuceTest.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Autowired
    private RedisCacheService redisCacheService;


    @Test
    public void get() {
        // TODO 测试线程安全
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
        );
        stringRedisTemplate.opsForValue().set("k1", "v1");
        final String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("[字符缓存结果] - [{}]", k1);
        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        String key = "lettuce:user:2";
        redisCacheTemplate.opsForValue().set(key, new User(2L, "小明", "6666"));
        // TODO 对应 String（字符串）
        final User user= (User) redisCacheTemplate.opsForValue().get(key);
        log.info("[对象缓存结果] - [{}]", user);
    }

    @Test
    public void test() {
        redisCacheService.setObject("lettuce:user:3", new User(3L, "小海", "6666"));
        User user = (User) redisCacheService.getObject("lettuce:user:3");
        System.out.println("user=" +user+ "");
    }
}
