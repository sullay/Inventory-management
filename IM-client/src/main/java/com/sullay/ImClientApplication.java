package com.sullay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ImClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImClientApplication.class, args);
	}
}
