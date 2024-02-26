package com.marcos.findafriend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.findafriend.application.entites.user.User;
import com.marcos.findafriend.application.entites.user.UserDTO;
import com.marcos.findafriend.application.use_case.CreateUsersUseCase;

@RestController
@RequestMapping("/user")
public class CreateUserController {
    private final CreateUsersUseCase created;

    public CreateUserController(CreateUsersUseCase service) {
        this.created = service;
    }

    @PostMapping("/create")
    public ResponseEntity<User> create( @RequestBody UserDTO data) {
        User createUser = this.created.created(data);
        return ResponseEntity.ok().body(createUser);
    }
}
