package com.authorizen.userauthh.config;

import java.util.Base64.Decoder;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY = "7a1ca2c8afd7e73cf0c6b4350e89a5d19d9351892d453c8381e09447331457aa";

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    // private Claims extractAllClaims(String token){
    //     return Jwts
    //         .parserBuilder()
    //         .setSigningKey(getSignInKey())
    //         .build()
    //         .parseClaimsJws(token)
    //         .getBody();
    // }
    private Claims extractAllClaims(String token){
    return Jwts
        .parser() // Use parser() instead of parserBuilder()
        .verifyWith(getSignInKey()) // Use verifyWith() instead of setSigningKey()
        .build()
        .parseSignedClaims(token) // Use parseSignedClaims() instead of parseClaimsJws()
        .getPayload(); // Use getPayload() instead of getBody()
}
    private SecretKey getSignInKey() {

        byte[] SecretKeyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(SecretKeyBytes);
        
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getSignInKey'");
    }

}
