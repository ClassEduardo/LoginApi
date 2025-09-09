package com.Desafio.LoginApi.Application.Interfaces;

import com.Desafio.LoginApi.Domain.Model.User;

public interface IRegisterUserUseCase {
    User Execute(String username, String password);
}
