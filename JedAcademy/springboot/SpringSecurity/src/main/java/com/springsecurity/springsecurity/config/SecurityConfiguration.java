package com.springsecurity.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
  private static final String[] WHITE_LIST = {
          "/swagger-ui/**",
          "/v3/api-docs/**",
          "/swagger-resources/**",
          "/api/v1/test/**",
          "/api/v1/sign/**",
          "/api/v1/profile/**"
  };

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
            .csrf(AbstractHttpConfigurer::disable)
            .cors(cors->cors.configurationSource(request->{
              CorsConfiguration config = new CorsConfiguration();
              config.setAllowedOrigins(List.of("*"));
              config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
              config.setAllowedHeaders(List.of("*"));
              config.setAllowCredentials(true);
              return config;
            }))
            .authorizeHttpRequests((auth)->auth
//            .anyRequest().permitAll()
//              .requestMatchers("api/v1/user/**").permitAll()
//              .requestMatchers(HttpMethod.GET,"api/v1/user/**").permitAll()
                .requestMatchers(WHITE_LIST).permitAll()

    ).httpBasic(withDefaults()).build();
  }
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
