package com.marcos.findafriend.application.entites.pets;

import java.util.List;
import java.util.UUID;

public record PetsResponseDTO(UUID id, String name, String descricao, Integer idade, String porte, String energia, String independencia, List<String> fotos, String requisitos, String user) {
    public PetsResponseDTO(Pets pets) {
        this(
            pets.getId(),
            pets.getName(),
            pets.getDescricao(),
            pets.getIdade(),
            pets.getPorte(),
            pets.getEnergia(),
            pets.getIndependencia(),
            pets.getFotos(),
            pets.getRequisitos(),
            pets.getUsers().getName()
        );
    }
}
