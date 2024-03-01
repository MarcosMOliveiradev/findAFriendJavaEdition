package com.marcos.findafriend.application.use_case.pets;

import com.marcos.findafriend.application.entites.pets.Pets;
import com.marcos.findafriend.repositories.PetsRepositories;
import com.marcos.findafriend.repositories.UsersRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreatePetsUseCase {

    @Autowired
    private final PetsRepositories petsRepositories;
    @Autowired
    private final UsersRepositories usersRepositories;

    public void create(String email, Pets pets) {
        UUID user = this.usersRepositories.findUserByEmail(email).getId();

        Pets createPet = new Pets();

    }
}
