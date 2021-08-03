package com.panBattle.PanbattleService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.panBattle.modal")
@EnableJpaRepositories("com.panBattle.dao")
@ComponentScan({"com.panBattle.controller","com.panBattle.service","com.panBattle.exceptions"})
public class PanbattleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PanbattleServiceApplication.class, args);
	}

}
