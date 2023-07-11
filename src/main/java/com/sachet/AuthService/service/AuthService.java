package com.sachet.AuthService.service;

import com.sachet.AuthService.models.JwtResponse;
import com.sachet.AuthService.models.User;
import com.sachet.AuthService.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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
    return userRepository.save(user)
        .map(userModel -> {
          String token = jwtService.generateToken(userModel);
          return new JwtResponse(token);
        });
  }
}
