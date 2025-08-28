package com.authorizen.userauthh.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorizen.userauthh.dto.AuthenticationResponse;
import com.authorizen.userauthh.dto.RegisterRequest;
import com.authorizen.userauthh.dto.loginRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private AuthenticationService service;
     public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
        @Valid
        @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
        @RequestBody loginRequest request
    ){
        return ResponseEntity.ok(service.login(request));

    }
    
}
