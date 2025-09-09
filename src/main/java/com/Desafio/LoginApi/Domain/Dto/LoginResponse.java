package com.Desafio.LoginApi.Domain.Dto;

public class LoginResponse {
    private Boolean success;
    private String message;
    private String token;

    public LoginResponse(Boolean success, String message, String token) {
        this.success = success;
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }
    
    public Boolean getSucess() {
        return success;
    }

    public String getToken() {
        return token;
    }
}
