package com.agile.agiletest.traintickets;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.agile.agiletest.traintickets.dao")
public class TrainticketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainticketsApplication.class, args);
    }

}
