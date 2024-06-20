package com.examplespringboot.Example1SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.controller")
@EntityScan("com.entity")
public class Example1SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Example1SpringBootApplication.class, args);
	}

}
