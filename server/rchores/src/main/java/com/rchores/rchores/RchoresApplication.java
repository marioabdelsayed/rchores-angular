package com.rchores.rchores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class RchoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(RchoresApplication.class, args);
	}


	@PostConstruct
	public void printJdbcUrl() {
    	System.out.println("JDBC_DATABASE_URL: " + System.getenv("JDBC_DATABASE_URL"));
	}
}
