package com.sachet.AuthService.service;

import com.sachet.AuthService.models.JwtResponse;
import com.sachet.AuthService.models.User;
import com.sachet.AuthService.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthService {
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;
  public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }
  public Mono<JwtResponse> signUp(User user) {

  }
}
