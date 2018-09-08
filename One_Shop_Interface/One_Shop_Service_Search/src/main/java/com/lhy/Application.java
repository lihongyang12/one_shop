package com.lhy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableScheduling
public class Application {
	
	@Bean
	public ObjectMapper initJackson() {
		return new ObjectMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
