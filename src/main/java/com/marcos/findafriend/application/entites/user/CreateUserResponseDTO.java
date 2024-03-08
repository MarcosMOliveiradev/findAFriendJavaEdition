package com.marcos.findafriend.application.entites.user;

import java.util.UUID;

public record CreateUserResponseDTO(String name, String email, Role role, UUID id) {
    public CreateUserResponseDTO(User user) {
        this(user.getName(), user.getEmail(), user.getRole(), user.getId());
    }
}
