package com.example.login.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResponseDO<T> {
    public boolean success;
    public String message;
    public T data;

    public ResponseDO(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean success() {
        return success;
    }

    public String message() {
        return message;
    }

    public T data() {
        return data;
    }
}
