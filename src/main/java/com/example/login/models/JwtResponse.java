package com.example.login.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JwtResponse {

    public String access_token;
    public String token_type;
    public String refresh_token;

    public JwtResponse(String access_token, String token_type, String refresh_token) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.refresh_token = refresh_token;
    }

    public String access_token() {
        return access_token;
    }

    public String token_type() {
        return token_type;
    }

    public String refresh_token() {
        return refresh_token;
    }
}
