package br.fiap.com.apisphere.user.dto;

import java.time.LocalDateTime;

import br.fiap.com.apisphere.user.User;


public record UserFormRequest(String name,
        String bio, 
        String email,
        String password) {
        
    public User toModel() { 
        return User.builder()
                .name(name)
                .bio(bio)
                .email(email)
                .password(password)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
