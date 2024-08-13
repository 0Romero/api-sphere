package br.fiap.com.apisphere.user.dto;

import java.time.LocalDateTime;



public record UserResponse (
    Long id,
    String name,
    String bio,
    String email,
    LocalDateTime createdAt,
    LocalDateTime updatedAt

){
   public static UserResponse fromModel(br.fiap.com.apisphere.user.User user) {
    return new UserResponse(
        user.getId(),
        user.getName(),
        user.getBio(),
        user.getEmail(),
        user.getCreatedAt(),
        user.getUpdatedAt()

        
    );
   }
}
