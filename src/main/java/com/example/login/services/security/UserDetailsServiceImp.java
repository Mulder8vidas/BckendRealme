package com.example.login.services.security;



import com.example.login.entity.AuthEntity;
import com.example.login.entity.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {



    @Autowired
    private AuthRepository repository;

    //Buscamos el usuario por su nombre  y si existe guardamos sus datos en un objeto de tipo user para la validacion
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        if (s == null || s.trim().length() == 0 || s.equalsIgnoreCase("")) {

            throw new RuntimeException("error usuario invalido");

        }
        Optional<AuthEntity> user = this.repository.findByUsername(s);
        if (user.isEmpty()) {
            throw new RuntimeException("Error usuario invalido");
        }


        AuthEntity authEntity = user.get();

        User user1 = new User(s, authEntity.getPassword(), Collections.singleton(new SimpleGrantedAuthority(authEntity.getRol().toString())));
        user1.setNombrecompleto(authEntity.getUsername());


        return user1;
    }
}
