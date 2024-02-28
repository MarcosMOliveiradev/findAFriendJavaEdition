package com.marcos.findafriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.findafriend.application.entites.user.CreateUserResponseDTO;
import com.marcos.findafriend.application.entites.user.User;
import com.marcos.findafriend.application.entites.user.UserDTO;
import com.marcos.findafriend.application.use_case.user.CreateUsersUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class CreateUserController {
    
    @Autowired
    private final CreateUsersUseCase created;

    public CreateUserController(CreateUsersUseCase service) {
        this.created = service;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponseDTO> create( @Valid @RequestBody UserDTO data) {
        User createUser = this.created.created(data);
        if (createUser == null) return ResponseEntity.badRequest().build();
        CreateUserResponseDTO user = new CreateUserResponseDTO(createUser.getName(), createUser.getEmail(), createUser.getRole());
        return ResponseEntity.ok().body(user);
    }
}
