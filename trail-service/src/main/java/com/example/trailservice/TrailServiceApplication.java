package com.example.trailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TrailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrailServiceApplication.class, args);
	}

	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate(){

		return new RestTemplate();
	}

}
