package com.Desafio.LoginApi.Application.Interfaces;

import java.util.Optional;

public interface ILoginUserUseCase {
    Optional<String> Execute(String username, String password);
}
