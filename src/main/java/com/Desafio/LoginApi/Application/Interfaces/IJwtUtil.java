package com.Desafio.LoginApi.Application.Interfaces;

public interface IJwtUtil {
    String GenerateToken(String username);
    String ExtractUsername(String token);
    boolean ValidateToken(String token, String username);
    boolean IsTokenExpired(String token);
}
