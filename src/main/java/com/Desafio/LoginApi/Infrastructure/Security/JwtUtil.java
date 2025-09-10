package com.Desafio.LoginApi.Infrastructure.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import com.Desafio.LoginApi.Application.Interfaces.IJwtUtil;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil implements IJwtUtil {
    private static final Date EXPIRATION_TIME = new Date(System.currentTimeMillis() + 3600000);
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String GenerateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(EXPIRATION_TIME) // 1 hora
                .signWith(key)
                .compact();
    }

    public String ExtractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean ValidateToken(String token, String username) {
        return username.equals(ExtractUsername(token)) && !IsTokenExpired(token);
    }

    public boolean IsTokenExpired(String token) {
        Date dateExpiration = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();

        return dateExpiration.before(new Date());
    }
}
