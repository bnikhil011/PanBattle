package com.panBattle.PanbattleService;



import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@SpringBootApplication
@EntityScan("com.panBattle.modal")
@EnableJpaRepositories("com.panBattle.dao")
@ComponentScan({"com.panBattle.controller","com.panBattle.service","com.panBattle.exceptions"})
public class PanbattleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PanbattleServiceApplication.class, args);
	}
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://localhost:4201"));
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		config.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type","Accept","Authorization","Origin,Accept","Cache-Control","X-Requested-With","Access-Control-Request-Method","Access-Control-Request-Headers"));
		UrlBasedCorsConfigurationSource ubc = new UrlBasedCorsConfigurationSource();
		ubc.registerCorsConfiguration("/**", config);
		return new CorsFilter(ubc);
	}
	
	

}
