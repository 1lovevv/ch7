package com.example.ch7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"mapper"})
public class Ch7Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch7Application.class, args);
    }

}
