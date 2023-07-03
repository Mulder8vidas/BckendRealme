package com.example.login.services;

import com.example.login.entity.AuthEntity;
import com.example.login.entity.AuthRepository;
import com.example.login.entity.Producto;
import com.example.login.models.LoginDO;
import com.example.login.models.RegisterDO;
import com.example.login.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    private final AuthRepository authRepository;


    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public Response login(String username,String password){


        return this.authRepository.findAll().stream().filter(a-> a.getUsername().equalsIgnoreCase(username) && a.getPassword().equalsIgnoreCase(password)).toList().size()>0 ? new Response("Usuario Logeado"): new Response("Usuario o clave incorrectas");
    }

    public Response registrar(RegisterDO data){
        try {
            AuthEntity authEntity = new AuthEntity();
            authEntity.setUsername(data.getUsername());
            authEntity.setPassword(data.getPassword());
            authEntity.setNombre(data.getNombre());
            authEntity.setApellido(data.getApellido());
            AuthEntity save = this.authRepository.save(authEntity);
            return new Response("Usuario creado correctamente");
        }catch (Exception ex){
            return new Response(ex.getMessage());
        }
    }
}
