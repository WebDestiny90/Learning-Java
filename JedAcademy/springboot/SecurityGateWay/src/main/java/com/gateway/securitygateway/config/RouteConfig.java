package com.gateway.securitygateway.config;


import com.gateway.securitygateway.filter.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RouteConfig {
  @Value("${services.user.url}")
  private String userUrl;

  private final JwtFilter jwtFilter;

  @Bean
  public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder) {
    return locatorBuilder.routes()
            .route("sign", r-> r.path("/api/v1/sign/**").uri(userUrl))

            .route("destiny", r-> r.path("/api/v1/test/**")
                    .or()
                    .path("/api/v1/profile/**")
                    .filters(f -> f.filter(jwtFilter))
                    .uri(userUrl)).build();
  }
}
