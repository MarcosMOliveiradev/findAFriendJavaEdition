package com.marcos.findafriend.application.entites.user;

public record CreateUserResponseDTO(String name, String email, Role role) {
    public CreateUserResponseDTO(User user) {
        this(user.getName(), user.getEmail(), user.getRole());
    }
}
