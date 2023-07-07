package com.solar4america;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class SpringBooter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBooter.class, args);
    }

}