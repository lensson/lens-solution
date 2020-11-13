package com.lens.blog.admin;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.oas.annotations.EnableOpenApi;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @author Lens Chen
 * @created 2020-11-12 8:36 AM
 * @Description
 */

@EnableTransactionManagement
@EnableOpenApi
@EnableDiscoveryClient
@EnableCaching
@EnableRabbit
@SpringBootApplication
@EnableFeignClients("com.lens.blog.common.feign")
@ComponentScan(basePackages = {
        "com.lens.blog.common.config",
        "com.lens.blog.common.fallback",
        "com.lens.blog.utils",
        "com.lens.blog.admin",
        "com.lens.blog.xo.utils",
        "com.lens.blog.xo.service"
})
public class LensBlogAdminBackendApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(LensBlogAdminBackendApplication.class, args);
    }

    /**
     * 设置时区
     */
    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //配置允许跨域访问的路径
                registry.addMapping("/**/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .exposedHeaders("")
                        .maxAge(3600);
            }
        };
    }
}
