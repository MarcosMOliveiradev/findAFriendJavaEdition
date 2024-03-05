package com.marcos.findafriend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.marcos.findafriend.application.entites.user.User;


public interface UsersRepositories extends JpaRepository<User, UUID> {
    UserDetails findByEmail(String email);
    User findUserByEmail(String email);

}