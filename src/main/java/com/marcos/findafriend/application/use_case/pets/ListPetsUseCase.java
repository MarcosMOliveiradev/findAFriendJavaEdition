package com.marcos.findafriend.application.use_case.pets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.findafriend.application.entites.pets.PetsResponseDTO;
import com.marcos.findafriend.repositories.PetsRepositories;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListPetsUseCase {

    @Autowired
    private PetsRepositories petsRepositories;

    public List<PetsResponseDTO> listPets() {
        List<PetsResponseDTO> list = this.petsRepositories.findAll().stream().map(PetsResponseDTO::new).toList();

        return list;
    }
    
}
