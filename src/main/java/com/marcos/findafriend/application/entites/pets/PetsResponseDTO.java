package com.marcos.findafriend.application.entites.pets;

public record PetsResponseDTO(String pet, String user) {
    public PetsResponseDTO(Pets pets) {
        this(pets.getName(), pets.getUsers().getName());
    }
}
