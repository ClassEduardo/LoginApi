package com.Desafio.LoginApi.Interfaces.Controller;

import java.util.function.Function;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.Desafio.LoginApi.Application.UseCase.LoginUserUseCase;
import com.Desafio.LoginApi.Application.UseCase.RegisterUserUseCase;
import com.Desafio.LoginApi.Domain.Model.User;
import com.Desafio.LoginApi.Interfaces.Dto.LoginRequest;
import com.Desafio.LoginApi.Interfaces.Dto.LoginResponse;

public class AuthController {
    private final RegisterUserUseCase _registerUserUseCase;
    private final LoginUserUseCase _loginUserUseCase;

    public AuthController(RegisterUserUseCase registerUserUseCase, LoginUserUseCase loginUserUseCase) {
        this._registerUserUseCase = registerUserUseCase;
        this._loginUserUseCase = loginUserUseCase;
    }

    @PostMapping("/register")
    public User Register(@RequestBody LoginRequest request) {
        return _registerUserUseCase.Execute(request.getUsername(), request.getPassword());
    }

    @PostMapping("/login")
    public LoginResponse Login(@RequestBody LoginRequest request) {
        Function<String, LoginResponse> gerarLoginRequestSucesso = token -> new LoginResponse(true,
                "Login relizado com sucesso!", token);

        return _loginUserUseCase.Execute(request.getUsername(), request.getPassword())
                .map(gerarLoginRequestSucesso)
                .orElse(new LoginResponse(false, "Credenciais inválidas", null));
    }
}
