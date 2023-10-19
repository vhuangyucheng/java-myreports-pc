package com.solar4america;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.solar4america.mapper")
public class SpringBooter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBooter.class, args);
    }
}