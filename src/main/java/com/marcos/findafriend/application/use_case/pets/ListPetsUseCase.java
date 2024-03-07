package com.marcos.findafriend.application.use_case.pets;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.marcos.findafriend.application.entites.pets.Pets;
import com.marcos.findafriend.application.entites.user.User;
import com.marcos.findafriend.application.util.GetLocateUser;
import com.marcos.findafriend.repositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.findafriend.application.entites.pets.PetsResponseDTO;
import com.marcos.findafriend.repositories.PetsRepositories;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListPetsUseCase {

    @Autowired
    private final PetsRepositories petsRepositories;
    private final UsersRepositories usersRepositories;

    public List<PetsResponseDTO> listPets() {
        List<PetsResponseDTO> list = this.petsRepositories.findAll().stream().map(PetsResponseDTO::new).toList();

        return list;
    }


    public Pets listPetForId(String email, UUID id) throws URISyntaxException, IOException, InterruptedException {
        User user = this.usersRepositories.findUserByEmail(email);
        GetLocateUser Locate = new GetLocateUser();

        String userLocate = Locate.getLocate(user.getCep());

        Optional<Pets> pet = this.petsRepositories.findById(id);
        Pets ong = pet.get();

        String cepOng = Locate.getLocate(ong.getUsers().getCep());


        if (!userLocate.equals(cepOng)) {
            return null;
        }

        return ong;
    }
}
