package com.backend.retail_website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.backend.retail_website")
public class RetailWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailWebsiteApplication.class, args);
	}
}