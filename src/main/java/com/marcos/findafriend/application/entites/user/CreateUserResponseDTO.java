package com.marcos.findafriend.application.entites.user;

import java.util.Optional;
import java.util.UUID;

public record CreateUserResponseDTO(String name, String email, Role role, UUID id) {
    public CreateUserResponseDTO(User user) {
        this(user.getName(), user.getEmail(), user.getRole(), user.getId());
    }

//    public CreateUserResponseDTO(Optional<User> user) {
//        var response = user.get();
//        this(response.getName(), response.getEmail(), response.getRole(), response.getId());
//    }
}
