package com.example.login.services;

import com.example.login.entity.AuthEntity;
import com.example.login.entity.AuthRepository;
import com.example.login.entity.enm.Rol;
import com.example.login.models.JwtResponse;
import com.example.login.models.RegisterDO;
import com.example.login.models.Response;
import com.example.login.models.ResponseDO;
import com.example.login.services.security.JwtUtil;
import com.example.login.services.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {


    private final AuthRepository authRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    public AuthService(AuthRepository authRepository, JwtUtil jwtUtil) {
        this.authRepository = authRepository;
        this.jwtUtil = jwtUtil;
    }

    public ResponseDO<?> login(String username,String password){


     try {
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
         SecurityContextHolder.getContext().setAuthentication(authentication);
         User userDetails = (User) authentication.getPrincipal();
         String token = this.jwtUtil.generateToken(userDetails.getUsername(), userDetails.getAuthorities().stream().findFirst().get().getAuthority(),userDetails.getNombrecompleto());
         return new ResponseDO<>(true, "Usuario logeado con exito", new JwtResponse(token, "Bearer", UUID.randomUUID().toString()));
     }catch (Exception ex){
         return new ResponseDO<>(false, ex.getMessage(), null);
     }



    }

    public Response registrar(RegisterDO data){
        try {
            AuthEntity authEntity = new AuthEntity();
            authEntity.setUsername(data.getUsername());
            authEntity.setPassword(data.getPassword());
            authEntity.setNombre(data.getNombre());
            authEntity.setApellido(data.getApellido());
            authEntity.setRol(Rol.USER);
            AuthEntity save = this.authRepository.save(authEntity);
            return new Response("Usuario creado correctamente");
        }catch (Exception ex){
            return new Response(ex.getMessage());
        }
    }
}
