package com.Desafio.LoginApi.Application.UseCase;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Desafio.LoginApi.Application.Interfaces.IRegisterUserUseCase;
import com.Desafio.LoginApi.Application.Interfaces.IUserRepository;
import com.Desafio.LoginApi.Domain.Model.User;

@Service
public class RegisterUserUseCase implements IRegisterUserUseCase {
    private final IUserRepository _userRepository;
    private final PasswordEncoder _passwordEncoder;

    public RegisterUserUseCase(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this._userRepository = userRepository;
        this._passwordEncoder = passwordEncoder;
    }

    public User Execute(String username, String password) {
        String hashedPassword = _passwordEncoder.encode(password);
        User user = new User(username, hashedPassword);
        return _userRepository.save(user);
    }
}
