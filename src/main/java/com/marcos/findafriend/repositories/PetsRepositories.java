package com.marcos.findafriend.repositories;

import com.marcos.findafriend.application.entites.pets.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetsRepositories extends JpaRepository<Pets, UUID> {
}
