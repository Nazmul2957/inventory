package com.example.inventory3.inventory3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:/component.xml")
public class Inventory3Application {

	public static void main(String[] args) {
		SpringApplication.run(Inventory3Application.class, args);
	}
}
