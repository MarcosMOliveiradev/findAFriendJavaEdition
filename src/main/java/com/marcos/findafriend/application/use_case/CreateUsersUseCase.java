package com.marcos.findafriend.application.use_case;

import org.springframework.stereotype.Service;

import com.marcos.findafriend.application.entites.user.User;
import com.marcos.findafriend.application.entites.user.UserDTO;
import com.marcos.findafriend.repositories.UsersRepositories;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUsersUseCase {

    private UsersRepositories repository;

    public User created(UserDTO data) {
        User createUser = new User(data);
        return this.repository.save(createUser);
    }
}
