package com.marcos.findafriend.application.entites.pets;

import java.util.List;

public record PetsDTO(
    String name,
    String descricao,
    Integer idade,
    String porte,
    String energia,
    String independencia,
    List<String> fotos,
    String requisitos
    ) {
    
}
