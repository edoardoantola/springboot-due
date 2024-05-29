package com.majorbit.springboot_due;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.majorbit.springboot_due")
public class SpringbootDueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDueApplication.class, args);
	}

}
