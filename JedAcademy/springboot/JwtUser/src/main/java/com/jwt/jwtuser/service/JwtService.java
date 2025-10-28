package com.jwt.jwtuser.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
  @Value("${jwt.secret}")
  private String SECRET_KEY;
  @Value("${jwt.expire}")
  private String EXPIRATION_TIME;

  private Key getSigningKey() {
    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
  }

  public String generateToken(String firstName) {
    return Jwts.builder()
            .setSubject(firstName)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(EXPIRATION_TIME)))
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();
  }

  public Claims jwtParser(String token) {
    return Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
  }

  public String valid(String token) {
    var claims = jwtParser(token);
    if (claims.getExpiration().before(new Date())) {
      throw new RuntimeException("token expired");
    }
    return claims.getSubject();
  }
}
