package com.marcos.findafriend.application.use_case.pets;

import com.marcos.findafriend.application.entites.ong.Ong;
import com.marcos.findafriend.application.entites.pets.Pets;
import com.marcos.findafriend.application.entites.pets.PetsDTO;
import com.marcos.findafriend.application.entites.user.Role;
import com.marcos.findafriend.application.entites.user.User;
import com.marcos.findafriend.repositories.OngRepositories;
import com.marcos.findafriend.repositories.PetsRepositories;
import com.marcos.findafriend.repositories.UsersRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePetsUseCase {

    @Autowired
    private final PetsRepositories petsRepositories;
    @Autowired
    private final UsersRepositories usersRepositories;
    private final OngRepositories ongRepositories;

    public Pets create(String email, PetsDTO data) {
        User user = this.usersRepositories.findUserByEmail(email);
        Ong ong = this.ongRepositories.findByUserId(user);

        if (user.getRole() == Role.USER)
            return null;

        Pets createPet = new Pets(
                data.name(),
                data.descricao(),
                data.idade(),
                data.energia(),
                data.porte(),
                data.independencia(),
                data.fotos(),
                data.requisitos(),
                user,
                ong);

        return this.petsRepositories.save(createPet);
    }
}
