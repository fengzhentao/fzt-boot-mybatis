package com.fzt.boot;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableSwagger2Doc
public class FztBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FztBootApplication.class, args);
    }

}

