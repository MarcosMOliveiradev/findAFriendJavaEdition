package com.marcos.findafriend.application.use_case.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marcos.findafriend.application.entites.user.User;
import com.marcos.findafriend.application.entites.user.UserDTO;
import com.marcos.findafriend.repositories.UsersRepositories;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUsersUseCase {

    @Autowired
    private UsersRepositories repository;

    public User created(UserDTO data) {
        if(this.repository.findByEmail(data.email()) != null) {
            return null;
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User createUser = new User(data.name(), data.email(), data.cep(), data.numero(), data.contato(), encryptedPassword, data.avata(), data.role());
        return this.repository.save(createUser);
    }
}
