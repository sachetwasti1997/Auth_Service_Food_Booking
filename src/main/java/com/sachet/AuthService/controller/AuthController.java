package com.sachet.AuthService.controller;

import com.sachet.AuthService.models.JwtResponse;
import com.sachet.AuthService.models.Login;
import com.sachet.AuthService.models.User;

import com.sachet.AuthService.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Mono<JwtResponse> login(@RequestBody @Valid Login login) {
        return authService.login(login);
    }

    @PostMapping("/signup")
    public Mono<JwtResponse> signUp (@RequestBody @Valid User user) {
        return authService.signUp(user);
    }

    @PostMapping("/currentuser")
    public Mono<String> currentUser(Principal principal, @RequestHeader Map<String, String> headers) {
        List<String> hdr = new ArrayList<>();
        headers.forEach((key, value) -> {
            hdr.add(key);
            hdr.add(value);
        });
        return Mono.just("This is Auth Service "+hdr);
    }
}
