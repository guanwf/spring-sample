package com.github.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication(scanBasePackages={"com.github.spring.demo"})
public class SpringSapmleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSapmleApplication.class, args);
	}

}
