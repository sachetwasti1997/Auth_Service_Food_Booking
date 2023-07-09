package com.sachet.AuthService.service;

import com.sachet.AuthService.models.ExtractedToken;
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


public class JWTService {

    private final JwtParser parser;
    private final SecretKey secretKey;

    public JWTService(JwtParser parser, SecretKey secretKey) {
        this.secretKey = Keys.hmacShaKeyFor("#wed$443@3hg".getBytes());
        this.parser = Jwts.parserBuilder().setSigningKey(secretKey).build();
    }

    public String generateJwt(String userName, String email) {
        JwtBuilder jwts = Jwts.builder()
                .setSubject(userName+","+email)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(3, ChronoUnit.MINUTES)))
                .signWith(secretKey);

        return jwts.compact();
    }

    private ExtractedToken extractToken(String token) {
        Claims claims = parser.parseClaimsJws(token).getBody();
        String[] credentials = claims.getSubject().split(",");
        return new ExtractedToken(credentials[0], credentials[1]);
    }
}
