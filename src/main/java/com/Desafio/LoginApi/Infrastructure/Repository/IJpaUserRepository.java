package com.Desafio.LoginApi.Infrastructure.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Desafio.LoginApi.Application.Interfaces.IUserRepository;
import com.Desafio.LoginApi.Domain.Model.User;

public interface IJpaUserRepository extends JpaRepository<User, Long>, IUserRepository {
    Optional<User> findByUsername(String username);
}
