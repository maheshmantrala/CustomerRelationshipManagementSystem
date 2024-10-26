package com.mahesh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
public class CrmJwtAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmJwtAuthenticationApplication.class, args);
	}

}
