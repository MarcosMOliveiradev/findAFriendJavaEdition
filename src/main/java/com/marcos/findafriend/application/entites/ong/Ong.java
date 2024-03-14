package com.marcos.findafriend.application.entites.ong;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.marcos.findafriend.application.entites.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "ong")
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Ong(String name, String cep, Integer numero, String contato, User userId) {
        this.name = name;
        this.cep = cep;
        this.numero = numero;
        this.contato = contato;
        this.userId = userId;
    }
}
