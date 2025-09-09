package com.Desafio.LoginApi.Application.UseCase;

import java.util.*;
import java.util.function.*;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Desafio.LoginApi.Application.Interfaces.*;
import com.Desafio.LoginApi.Domain.Model.User;

@Service
public class LoginUserUseCase implements ILoginUserUseCase {
    private final IUserRepository _userRepository;   
    private final PasswordEncoder _passwordEncoder;
    private final IJwtUtil _jwtUtil;

    LoginUserUseCase(IUserRepository userRepository, PasswordEncoder passwordEncoder, IJwtUtil jwtUtil) {
        this._userRepository = userRepository;
        this._passwordEncoder = passwordEncoder;
        this._jwtUtil = jwtUtil;
    }

    public Optional<String> Execute(String username, String password) {
        Predicate<User> matchPassword = user -> _passwordEncoder.matches(password, user.getPassword());
        Function<User, String> generateToken = user -> _jwtUtil.GenerateToken(user.getUsername());
        
        return _userRepository.findByUsername(username)
                .filter(matchPassword)
                .map(generateToken);
    }
}
