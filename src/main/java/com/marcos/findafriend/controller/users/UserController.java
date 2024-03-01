package com.marcos.findafriend.controller.users;

import com.marcos.findafriend.application.use_case.user.ListUsersUseCase;
import com.marcos.findafriend.controller.exceptions.ExceptionDTO;
import com.marcos.findafriend.infra.security.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.marcos.findafriend.application.entites.user.CreateUserResponseDTO;
import com.marcos.findafriend.application.entites.user.User;
import com.marcos.findafriend.application.entites.user.UserDTO;
import com.marcos.findafriend.application.use_case.user.CreateUsersUseCase;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private final CreateUsersUseCase created;
    private final ListUsersUseCase list;

    @Autowired
    private TokenService tokenService;

    public UserController(CreateUsersUseCase service, ListUsersUseCase list, TokenService tokenService) {
        this.created = service;
        this.list = list;
    }

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody UserDTO data) {
        User createUser = this.created.created(data);

       ExceptionDTO UserAlredyExists = new ExceptionDTO("User alredy exists!", 409);
        if (createUser == null) return ResponseEntity.status(HttpStatus.CONFLICT).body(UserAlredyExists);

        CreateUserResponseDTO user = new CreateUserResponseDTO(createUser.getName(), createUser.getEmail(), createUser.getRole(), createUser.getId());
        return ResponseEntity.ok().body(user);
    }


    @GetMapping("/list")
    public ResponseEntity listUser(HttpServletRequest request) {
        var auth = request.getHeader("Authorization");
        String token = auth.replace("Bearer ", "");

        System.out.println(this.tokenService.validateToken(token));

        List<CreateUserResponseDTO> listUsers = this.list.getUsers();
        return ResponseEntity.ok().body(listUsers);
    }
}