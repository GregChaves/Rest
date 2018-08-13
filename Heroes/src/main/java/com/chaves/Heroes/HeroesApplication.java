package com.chaves.Heroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.chaves.Heroes.business.HeroesBusinessImpl;

@SpringBootApplication
@EnableJpaAuditing
public class HeroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroesApplication.class, args);
	}
	
	@Bean
	public HeroesBusinessImpl heroMapper(){
		return new HeroesBusinessImpl();
	}
	
}
