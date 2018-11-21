package com.desonz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.stom.member.mapper")
public class StomApplication {

    public static void main(String[] args) {
        SpringApplication.run(StomApplication.class, args);
    }
}