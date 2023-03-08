package com.RestApiDevProject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com")
@ComponentScan("com")
public class RestApiDev2Application {

	
	public static void main(String[] args) {
		SpringApplication.run(RestApiDev2Application.class, args);
	}
	

}
