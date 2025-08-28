package com.authorizen.userauthh.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.web.server.ServerSecurityMarker;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authorizen.userauthh.config.JwtService;
import com.authorizen.userauthh.dto.AuthenticationResponse;
import com.authorizen.userauthh.dto.RegisterRequest;
import com.authorizen.userauthh.dto.loginRequest;
import com.authorizen.userauthh.model.Role;
import com.authorizen.userauthh.model.User;
import com.authorizen.userauthh.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        // Check if a user with this email already exists
    if (repository.findByEmail(request.getEmail()).isPresent()) {
        // If an account with the email is found, throw an exception
        // This prevents creating a duplicate account
        throw new IllegalArgumentException("Email already in use.");
    }
        var user = User.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

public AuthenticationResponse login(loginRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
      .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
    // TODO Auto-generated method stub
    //throw new UnsupportedOperationException("Unimplemented method 'login'");
}
    
}
