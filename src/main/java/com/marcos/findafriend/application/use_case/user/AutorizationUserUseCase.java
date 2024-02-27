package com.marcos.findafriend.application.use_case.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marcos.findafriend.repositories.UsersRepositories;

@Service
public class AutorizationUserUseCase implements UserDetailsService {

    @Autowired
    private UsersRepositories usersRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepositories.findByEmail(username);
    }
    
}
