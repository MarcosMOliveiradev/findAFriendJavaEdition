package com.marcos.findafriend.application.entites.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @Email(message = "O campo [email] deve conter um Email valido!")
    private String email;

    private String cep;

    @NotBlank
    private Integer numero;
    private String contato;

    @Length(min = 6, max = 20)
    private String password;
    private String avata;
    private Role role;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public User(UserDTO userDTO){
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.cep = userDTO.cep();
        this.numero = userDTO.numero();
        this.contato = userDTO.contato();
        this.password = userDTO.password();
        this.avata = userDTO.avata();
        this.role = userDTO.role();
    }
}
