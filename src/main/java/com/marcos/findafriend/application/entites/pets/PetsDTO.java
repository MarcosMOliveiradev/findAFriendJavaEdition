package com.marcos.findafriend.application.entites.pets;

import java.util.List;

import com.marcos.findafriend.application.entites.user.User;

public record PetsDTO(
    String name,
    String descricao,
    Integer idade,
    String porte,
    String energia,
    String independencia,
    List<String> fotos,
    String requisitos,
    User user
    ) {

}
