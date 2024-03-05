package com.marcos.findafriend.application.use_case.user;

import com.marcos.findafriend.application.entites.user.CreateUserResponseDTO;
import com.marcos.findafriend.application.entites.user.User;
import com.marcos.findafriend.repositories.UsersRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListUsersUseCase {
    @Autowired
    private UsersRepositories repositories;

    public List<CreateUserResponseDTO> getUsers() {
        List<CreateUserResponseDTO> list = this.repositories.findAll().stream().map(CreateUserResponseDTO::new).toList();

        return list;
    }

    public Optional<User> ListForId(UUID id) {
        Optional<User> user = this.repositories.findById(id);

//        CreateUserResponseDTO userid = new CreateUserResponseDTO(user);
        return user;
    }
}
