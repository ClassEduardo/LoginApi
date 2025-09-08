package com.Desafio.LoginApi.Infrastructure.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Desafio.LoginApi.Domain.Model.User;
import com.Desafio.LoginApi.Domain.Repository.UserRepository;

public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository {
    Optional<User> findByUsername(String username);
}
