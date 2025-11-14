package com.gateway.securitygateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.security.Key;
import java.util.Date;

@Slf4j
@Component
public class JwtFilter implements GatewayFilter {
  @Value("${jwt.secret}")
  private String SECRET_KEY;

  private Key getSigningKey() {
    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
  }

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    try {
      String token = extractJwtFromRequest(exchange.getRequest().getHeaders().getFirst("Authorization"));

//      Jws<Claims> claims = Jwts.parser()
//              .setSigningKey(getSigningKey())
//              .parseClaimsJws(token);

      Jws<Claims> claims = Jwts.parserBuilder()
              .setSigningKey(getSigningKey())
              .build()
              .parseClaimsJws(token);

      if (token == null || !validateToken(claims)) {
        log.error("Invalid or missing JWT token");
        return handleUnauthorized(exchange);
      }

//      String email = claims.getBody().getSubject();
      String email = claims.getBody().get("email", String.class);
      String id = claims.getBody().get("user-id", String.class);
      ServerHttpRequest mutatedRequest = exchange.getRequest()
          .mutate()
          .header("email", email)
          .header("user-id", id)
          .build();

      ServerWebExchange mutatedExchange = exchange
          .mutate()
          .request(mutatedRequest)
          .build();

      return chain.filter(mutatedExchange);
    }
    catch (Exception e) {
      log.error("Error processing JWT tokent", e);
      return handleUnauthorized(exchange);
    }
  }

  private Mono<Void> handleUnauthorized(ServerWebExchange exchange) {
    ServerHttpResponse response = exchange.getResponse();
    response.setStatusCode(HttpStatus.UNAUTHORIZED);
    return response.setComplete();
  }

  private String extractJwtFromRequest(String authorizationHeader) {
    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      return authorizationHeader.substring(7);
    }
    return null;
  }

  private boolean validateToken(Jws<Claims> claimsJws) {
    try {
      return !claimsJws.getBody().getExpiration().before(new Date());
    }
    catch (Exception e) {
      return false;
    }
  }

}
