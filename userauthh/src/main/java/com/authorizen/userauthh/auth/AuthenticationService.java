package com.authorizen.userauthh.auth;

import org.springframework.security.config.web.server.ServerSecurityMarker;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authorizen.userauthh.model.Role;
import com.authorizen.userauthh.model.User;
import com.authorizen.userauthh.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    repository.save(user);
        
        return null;
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

public AuthenticationResponse login(loginRequest request) {
    return null;
    // TODO Auto-generated method stub
    //throw new UnsupportedOperationException("Unimplemented method 'login'");
}
    
}
