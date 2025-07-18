package io.github.murilogustavo.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("clients", r -> r.path("/clients/**").uri("lb://client-service"))
				.route("cards", r -> r.path("/cards/**").uri("lb://card-service"))
				.route("credit-evaluators", r -> r.path("/credit-evaluators/**").uri("lb://credit-evaluator-service"))
				.build();
	}
}
