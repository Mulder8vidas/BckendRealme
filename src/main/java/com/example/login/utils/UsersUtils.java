package com.example.login.utils;

import com.example.login.entity.AuthEntity;
import com.example.login.entity.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersUtils {

    @Autowired
    private AuthRepository repository;
    public String getUserCode(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    public String getNombre(){
        String userCode = this.getUserCode();

        Optional<AuthEntity> byUsername = this.repository.findByUsername(userCode);
        return byUsername.get().getNombre()+" "+byUsername.get().getApellido();
    }
}
