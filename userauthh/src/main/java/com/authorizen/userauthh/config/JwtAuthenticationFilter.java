package com.authorizen.userauthh.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JwtService jwtService;
    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request, 
        @NonNull HttpServletResponse response, 
        @NonNull FilterChain filterChain
        )
            throws ServletException, IOException {
                final String authheader = request.getHeader("Authorization");
                final String jwt;
                final String userEmail; 

                if(authheader == null || !authheader.startsWith("Bearer ")){
                    filterChain.doFilter(request, response);
                    return;
                }
                jwt = authheader.substring(7);
                userEmail = jwtService.extractUsername(jwt); // todo extract email from JWT token;
                
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
    }
    
    
}
