package com.navaraj.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.navaraj")
@EnableAutoConfiguration
public class CsvSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvSpringApplication.class, args);
	}
}