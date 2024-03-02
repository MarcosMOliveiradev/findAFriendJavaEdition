package com.marcos.findafriend.controller.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.findafriend.application.entites.pets.PetsDTO;
import com.marcos.findafriend.application.use_case.pets.CreatePetsUseCase;
import com.marcos.findafriend.infra.security.TokenService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pets")
public class PetsControllers {
    @Autowired
    private final CreatePetsUseCase createPetsUseCase;

    @Autowired
    private TokenService tokenService;

    private PetsControllers(CreatePetsUseCase createPetsUseCase) {
        this.createPetsUseCase = createPetsUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<@Valid PetsDTO> create(@Valid @RequestBody PetsDTO data, HttpServletRequest request) {
        var auth = request.getHeader("Authorization");
        String token = auth.replace("Bearer ", "");
        String email = this.tokenService.validateToken(token);

        this.createPetsUseCase.create(email, data);
        return ResponseEntity.ok().body(data);
    }
}
