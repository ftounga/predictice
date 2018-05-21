package com.tounga.predictice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.tounga.predictice.bean.StripeClient;

@SpringBootApplication
@PropertySource("classpath:message.properties")
public class PredicticeApplication {

	private static final String STRIPE_KEY = "stripe.key";
	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(PredicticeApplication.class, args);
	}
	@Bean
	public StripeClient getStripeClient(){
		return new StripeClient(env.getProperty(STRIPE_KEY));
	}
}
