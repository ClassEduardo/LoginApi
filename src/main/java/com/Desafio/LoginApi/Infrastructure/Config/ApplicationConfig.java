package com.Desafio.LoginApi.Infrastructure.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.Desafio.LoginApi.Application.Interfaces.IUserRepository;
import com.Desafio.LoginApi.Infrastructure.Repository.IJpaUserRepository;

@Configuration
@EnableJpaRepositories(basePackages = "com.Desafio.LoginApi.Infrastructure.Repository")
public class ApplicationConfig {

    @Bean
    public IUserRepository userRepository(IJpaUserRepository jpaUserRepository) {
        return jpaUserRepository;
    }

}
