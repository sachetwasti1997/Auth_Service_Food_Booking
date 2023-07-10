package com.sachet.AuthService.service;

import com.sachet.AuthService.models.ExtractedToken;
import com.sachet.AuthService.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JWTService {

    public String generateToken(User userModel){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userModel);
    }

    private String createToken(Map<String, Object> claims, User userModel){
        SecretKey key = Keys.hmacShaKeyFor("#wed$443@3hg".getBytes());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userModel.getEmail())
                .claim("roles", userModel.getRoles())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(key).compact();
    }
}
