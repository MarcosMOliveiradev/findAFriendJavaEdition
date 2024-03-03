package com.marcos.findafriend.controller.pets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.findafriend.application.entites.pets.Pets;
import com.marcos.findafriend.application.entites.pets.PetsDTO;
import com.marcos.findafriend.application.entites.pets.PetsResponseDTO;
import com.marcos.findafriend.application.use_case.pets.CreatePetsUseCase;
import com.marcos.findafriend.application.use_case.pets.ListPetsUseCase;
import com.marcos.findafriend.infra.security.TokenService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pets")
public class PetsControllers {
    @Autowired
    private final CreatePetsUseCase createPetsUseCase;
    private final ListPetsUseCase listPetsUseCase;

    @Autowired
    private TokenService tokenService;

    private PetsControllers(CreatePetsUseCase createPetsUseCase, ListPetsUseCase listPetsUseCase) {
        this.createPetsUseCase = createPetsUseCase;
        this.listPetsUseCase = listPetsUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody PetsDTO data, HttpServletRequest request) {
        var auth = request.getHeader("Authorization");
        String token = auth.replace("Bearer ", "");
        String email = this.tokenService.validateToken(token);

        Pets pets = this.createPetsUseCase.create(email, data);

        if (pets == null) {
            return ResponseEntity.badRequest().body("Voçê não tem permissão para cadastrar um pet");
        }
        PetsResponseDTO responsePets = new PetsResponseDTO(pets);
        return ResponseEntity.ok().body(responsePets);
    }


    @GetMapping("/list")
    public ResponseEntity<?> list() {
        List<PetsResponseDTO> list = this.listPetsUseCase.listPets();

        return ResponseEntity.ok().body(list);
    }
}
