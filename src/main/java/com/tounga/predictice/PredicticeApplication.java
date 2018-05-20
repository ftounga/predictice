package com.tounga.predictice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:message.properties")
public class PredicticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PredicticeApplication.class, args);
	}
}
