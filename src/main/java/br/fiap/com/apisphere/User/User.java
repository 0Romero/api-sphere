package br.fiap.com.apisphere.user;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; 
    String name; 
    String bio;
    String email;
    String password;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
