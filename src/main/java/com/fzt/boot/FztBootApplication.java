package com.fzt.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.fzt.boot.base.mapper")
public class FztBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FztBootApplication.class, args);
    }

}

