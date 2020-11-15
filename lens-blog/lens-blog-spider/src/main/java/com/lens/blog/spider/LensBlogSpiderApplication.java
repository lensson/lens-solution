package com.lens.blog.spider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableTransactionManagement
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@ComponentScan(basePackages = {
		"com.lens.blog.spider"})
public class LensBlogSpiderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LensBlogSpiderApplication.class, args);
	}


	@Bean
	public IdWorker idWorker() {
		return new IdWorker(1, 1);
	}

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		return corsConfiguration;
	}

	/**
	 * 跨域过滤器
	 *
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		return new CorsFilter(source);
	}
}
