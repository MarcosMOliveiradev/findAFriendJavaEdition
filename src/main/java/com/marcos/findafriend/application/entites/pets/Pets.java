package com.marcos.findafriend.application.entites.pets;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.marcos.findafriend.application.entites.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "pet")
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String descricao;
    private Integer idade;
    private String porte;
    private String energia;
    private String independencia;
    private List<String> fotos;
    private String requisitos;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User users;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Pets(
        String name,
        String descricao,
        Integer idade,
        String porte,
        String energia,
        String independencia,
        List<String> fotos,
        String requisitos,
        User users
    ){
        this.name = name;
        this.descricao = descricao;
        this.idade = idade;
        this.porte = porte;
        this.energia = energia;
        this.independencia = independencia;
        this.fotos = fotos;
        this.requisitos = requisitos;
        this.users = users;
    }
}
