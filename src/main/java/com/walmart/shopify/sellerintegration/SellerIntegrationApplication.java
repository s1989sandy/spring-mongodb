package com.walmart.shopify.sellerintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.walmart.shopify.repository")
@ComponentScan({"com.walmart.shopify.controller","com.walmart.shopify.repository"})
public class SellerIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerIntegrationApplication.class, args);
	}
	
}
