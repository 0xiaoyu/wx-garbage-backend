package com.yu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yu.dao")
public class RefuseClassificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefuseClassificationApplication.class, args);
    }

}
