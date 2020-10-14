package com.lens.wx.gzh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lens.wx.gzh.*.mapper")
public class GzhApplication {

    public static void main(String[] args) {
        SpringApplication.run(GzhApplication.class, args);
    }

}
