package com.lhy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class application {
	
	
	@Bean
	public ObjectMapper initJackson() {
		return new ObjectMapper();
	}
	
	public static void main(String[] args) {
		//����tomcat����
		SpringApplication.run(application.class, args);
	}
}
