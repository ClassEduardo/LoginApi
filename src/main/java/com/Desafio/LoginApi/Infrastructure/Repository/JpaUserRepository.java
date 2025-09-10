package com.Desafio.LoginApi.Infrastructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Desafio.LoginApi.Application.Interfaces.IUserRepository;
import com.Desafio.LoginApi.Domain.Model.User;

public interface JpaUserRepository extends JpaRepository<User, Long>, IUserRepository {

}
