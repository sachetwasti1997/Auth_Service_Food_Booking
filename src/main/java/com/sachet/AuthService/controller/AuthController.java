package com.sachet.AuthService.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @PostMapping("/currentuser")
    public Mono<String> currentUser() {
        return Mono.just("");
    }
}
