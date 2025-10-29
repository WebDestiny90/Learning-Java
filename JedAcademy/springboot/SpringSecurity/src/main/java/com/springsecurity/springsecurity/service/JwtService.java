package com.springsecurity.springsecurity.service;

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

  public String generateToken(String email) {
    return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(EXPIRATION_TIME)))
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();
  }
}
