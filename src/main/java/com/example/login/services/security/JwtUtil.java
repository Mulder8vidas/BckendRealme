package com.example.login.services.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class JwtUtil {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private static final String BEARER = "Bearer ";
    @Value("${ebisu.jwtSecret}")
    private String JWTSECRET;
    private final String ISSUER = "autonoma";
    @Value("${ebisu.jwtExpirationMs}")
    private int jwtExpirationMs;


    //username es dni y rol es el perfil
    public String generateToken(String username, String rol, String nombreCompleto) {


        return JWT.create().withSubject(username).withIssuedAt(new Date()).withClaim("USER", username).withExpiresAt(new Date((new Date()).getTime() + jwtExpirationMs))

                .withClaim("perfil", rol).withClaim("nombres", nombreCompleto).withIssuer(ISSUER).sign(Algorithm.HMAC256(JWTSECRET));
    }

    public String getUsername(String token) {

        return this.decodeJWT(token).getClaim("USER").asString();


    }

    public long getExpireIn(String token) {
        return this.decodeJWT(token).getExpiresAtAsInstant().toEpochMilli();
    }

    public DecodedJWT decodeJWT(String token) {

        System.out.println(token);
        if (!this.checkToken(token)) {
            throw new RuntimeException("Invalid access_token");
        }

        try {

            return JWT.require(Algorithm.HMAC256(this.JWTSECRET)).withIssuer(ISSUER).build().verify(token.substring(BEARER.length()));


        } catch (Exception ex) {



            if (ex.getClass().isAssignableFrom(TokenExpiredException.class)) {

            }

            throw new RuntimeException("Error in decode jwt");
        }

    }



    public boolean checkToken(String token) {
        return token != null && token.startsWith(BEARER) && token.split("\\.").length == 3;
    }


    public String parseJwt(String headerAuth) {


        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }

}
