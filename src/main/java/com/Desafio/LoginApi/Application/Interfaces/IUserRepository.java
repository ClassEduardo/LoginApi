package com.Desafio.LoginApi.Application.Interfaces;

import java.util.Optional;

import com.Desafio.LoginApi.Domain.Model.User;

public interface IUserRepository {
    Optional<User> findByUsername(String username);
    User save(User user);
}
