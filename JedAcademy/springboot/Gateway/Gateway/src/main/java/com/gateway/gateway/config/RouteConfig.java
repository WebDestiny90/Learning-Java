package com.gateway.gateway.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
  @Value("${services.user.url}")
  private String userUrl;

  @Value("${services.cars.url}")
  private String carUrl;

  @Bean
  public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder) {
    return locatorBuilder.routes()
            .route("user", r-> r.path("/api/v1/user/**").or().path("/api/v1/login/**").uri(userUrl))
            .route("cars", r -> r.path("/api/v1/car/**").uri(carUrl)).build();
  }
}
