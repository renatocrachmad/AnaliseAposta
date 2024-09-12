package br.com.liberdade.bets69.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Base64;
import javax.crypto.SecretKey;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expirationTime;

    // Gera uma chave secreta segura de 256 bits
    private SecretKey getSecretKey() {
        try {
            // Decodifica a chave secreta em Base64
            byte[] decodedKey = Base64.getDecoder().decode(secret);
            return Keys.hmacShaKeyFor(decodedKey);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Erro ao decodificar a chave secreta", e);
        }
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        try {
        	System.out.println("Token recebido: " + token);
            Claims claims = Jwts.parserBuilder()
                                .setSigningKey(getSecretKey())
                                .build()
                                .parseClaimsJws(token)
                                .getBody();
            return claims.getSubject();
        } catch (JwtException e) {
            throw new RuntimeException("Erro ao extrair o nome de usuário do token JWT", e);
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.err.println("JWT Token validation error: " + e.getMessage());
            return false;
        }
    }
}
