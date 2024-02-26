package com.marcos.findafriend.application.entites.user;

public record UserDTO(String name, String email, String cep, Integer numero, String contato, String password, String avata, Role role) {
    
}
