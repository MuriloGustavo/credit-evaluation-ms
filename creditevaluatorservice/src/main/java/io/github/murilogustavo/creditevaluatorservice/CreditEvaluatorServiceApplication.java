package io.github.murilogustavo.creditevaluatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CreditEvaluatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditEvaluatorServiceApplication.class, args);
	}

}
