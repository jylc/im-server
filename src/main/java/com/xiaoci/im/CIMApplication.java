package com.xiaoci.im;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.xiaoci.im.mapper.**")
public class CIMApplication {

    public static void main(String[] args) {
        SpringApplication.run(CIMApplication.class, args);
    }

}
