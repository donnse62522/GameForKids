package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.example.demo")
public class KidsGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(KidsGameApplication.class, args);
	}
}
