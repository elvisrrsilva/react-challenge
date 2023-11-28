package com.workana.challenge;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by: Elvis Ribeiro
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "React Challange", version = "1.0", description = "React Challange docs"))
public class Application {

	/**
	 * Start Spring Boot Application
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
