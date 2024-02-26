package com.marcos.findafriend.application.entites.pets;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String user;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
