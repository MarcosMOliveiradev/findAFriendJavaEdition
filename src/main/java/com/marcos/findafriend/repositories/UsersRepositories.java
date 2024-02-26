package com.marcos.findafriend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marcos.findafriend.application.entites.user.User;

public interface UsersRepositories extends JpaRepository<User, UUID> {

}