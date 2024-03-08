package com.marcos.findafriend.application.entites.ong;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import com.marcos.findafriend.application.entites.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "pet")
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome da ong não pode ficar em branco")
    private String name;

    private String cep;
    private Integer numero;

    @NotBlank(message = "O numero para contato é obrigatório!")
    private String contato;

    @ManyToAny
    @JoinColumn(name = "user_id")
    private User users;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Ong(String name, String cep, Integer numero, String contato, User users) {
        this.name = name;
        this.cep = cep;
        this.numero = numero;
        this.contato = contato;
        this.users = users;
    }
}
