package com.lens.blog.sms;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableRabbit
@EnableFeignClients("com.lens.blog.common.feign")
@ComponentScan(basePackages = {
        "com.lens.blog.utils",
        "com.lens.blog.common.config.feign",
        "com.lens.blog.common.fallback",
        "com.lens.blog.sms",
})
public class LensBlogSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LensBlogSmsApplication.class, args);
    }

}
