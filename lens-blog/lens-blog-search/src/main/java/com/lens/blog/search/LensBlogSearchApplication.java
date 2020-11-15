package com.lens.blog.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableOpenApi
@EnableDiscoveryClient
@EnableFeignClients("com.lens.blog.common.feign")
@ComponentScan(basePackages = {
		"com.lens.blog.common.config.feign",
		"com.lens.blog.common.handler",
		"com.lens.blog.utils",
		"com.lens.blog.search"
})
public class LensBlogSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LensBlogSearchApplication.class, args);
	}

}
