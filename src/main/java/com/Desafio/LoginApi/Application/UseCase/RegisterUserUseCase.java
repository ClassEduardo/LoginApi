package com.Desafio.LoginApi.Application.UseCase;


import org.springframework.security.crypto.password.PasswordEncoder;

import com.Desafio.LoginApi.Domain.Model.User;
import com.Desafio.LoginApi.Infrastructure.Repository.UserRepository;

public class RegisterUserUseCase {
    private final UserRepository _userRepository;
    private final PasswordEncoder _passwordEncoder;

    public RegisterUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this._userRepository = userRepository;
        this._passwordEncoder = passwordEncoder;
    }

    public User Execute(String username, String password) {
        String hashedPassword = _passwordEncoder.encode(password);
        User user = new User(username, hashedPassword);
        return _userRepository.save(user);
    }
}
