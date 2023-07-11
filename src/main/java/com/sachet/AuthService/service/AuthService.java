package com.sachet.AuthService.service;

import com.sachet.AuthService.exception.EmailAlreadyInUse;
import com.sachet.AuthService.models.JwtResponse;
import com.sachet.AuthService.models.User;
import com.sachet.AuthService.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class AuthService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JWTService jwtService;

  public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JWTService jwtService) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
  }

  public Mono<JwtResponse> signUp(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.findByEmail(user.getEmail())
        .flatMap(__ -> Mono.error(new EmailAlreadyInUse("Email Already in use", HttpStatus.BAD_REQUEST)))
        .switchIfEmpty(
            userRepository.save(user)
                .map(userR -> new JwtResponse(jwtService.generateToken(userR)))
        )
        .cast(JwtResponse.class);
  }
}
