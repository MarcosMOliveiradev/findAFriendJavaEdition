package com.marcos.findafriend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.findafriend.application.entites.ong.Ong;
import com.marcos.findafriend.application.entites.user.User;

public interface OngRepositories extends JpaRepository<Ong, UUID> {
    Ong findByUserId(User user_id);
}

