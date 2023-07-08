package com.sachet.AuthService.controller;

import com.sachet.AuthService.models.JwtResponse;
import com.sachet.AuthService.models.Login;
import com.sachet.AuthService.models.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Mono<JwtResponse>> login() {
        return ResponseEntity.ok(Mono.just(new JwtResponse("Rough Mongo Connection Established!")));
    }

    @PostMapping("/signup")
    public Mono<JwtResponse> signUp (@RequestBody User user) {
        return Mono.just(new JwtResponse("Successful SignUp"));
    }

    @PostMapping("/currentuser")
    public Mono<String> currentUser() {
        return Mono.just("");
    }
}
