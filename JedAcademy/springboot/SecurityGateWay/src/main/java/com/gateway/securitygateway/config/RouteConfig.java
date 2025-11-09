package com.gateway.securitygateway.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
  @Value("${services.user.url}")
  private String userUrl;

  @Bean
  public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder) {
    return locatorBuilder.routes()
            .route("sign", r-> r.path("/api/v1/sign/**").uri(userUrl)).build();
  }
}
