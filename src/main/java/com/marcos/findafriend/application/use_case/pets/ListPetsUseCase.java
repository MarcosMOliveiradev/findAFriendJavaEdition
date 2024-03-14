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

    // Lista todos os pets
    public List<PetsResponseDTO> listPets() {
        List<PetsResponseDTO> list = this.petsRepositories.findAll().stream().map(PetsResponseDTO::new).toList();

        return list;
    }

    // Lista o pet pelo id
    public Pets listPetForId(String email, UUID id) throws URISyntaxException, IOException, InterruptedException {

        // Tras as infos do usuario no banco
        User user = this.usersRepositories.findUserByEmail(email);
        GetLocateUser Locate = new GetLocateUser(); // função de verificação de localização, verifica de qual estado é o cep fornecido

        String userLocate = Locate.getLocate(user.getCep()); // passa o cep do usuario para a função locate

        Optional<Pets> pet = this.petsRepositories.findById(id); // tras as infos do pet no banco
        Pets ong = pet.get();

        if (ong.getOng() == null ) {
            throw new Error("Ong não encontrada");
        }

        String cepOng = Locate.getLocate(ong.getOng().getCep()); // passa o cep da ong para a função locate

        // caso os estados sejam diferentes retorna nulo
        if (!userLocate.equals(cepOng)) {
            return null;
        }

        return ong;
    }
}
