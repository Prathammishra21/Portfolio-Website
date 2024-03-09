package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.portfolio.repository")
public class PortfolioWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioWebsiteApplication.class, args);
	}

}
