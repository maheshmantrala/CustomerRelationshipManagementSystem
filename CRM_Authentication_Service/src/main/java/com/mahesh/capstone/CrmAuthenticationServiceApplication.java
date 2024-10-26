package com.mahesh.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class CrmAuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmAuthenticationServiceApplication.class, args);
	}

}
