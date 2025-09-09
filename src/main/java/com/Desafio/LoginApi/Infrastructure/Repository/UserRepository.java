package com.Desafio.LoginApi.Infrastructure.Repository;

import java.util.Optional;

import com.Desafio.LoginApi.Domain.Model.User;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    User save(User user);
}
