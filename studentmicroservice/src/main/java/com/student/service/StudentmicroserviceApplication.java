package com.student.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class StudentmicroserviceApplication {
	
	
	@Value("${address.service.url}")
	private String addressUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentmicroserviceApplication.class, args);
	}
	
	@Bean
	public WebClient client() {
		WebClient client = WebClient.builder()
					.baseUrl(addressUrl).build();
		
		return client;
	}

}
