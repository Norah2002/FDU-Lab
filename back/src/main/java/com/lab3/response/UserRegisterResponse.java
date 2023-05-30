package com.lab3.response;

import lombok.Data;

@Data
public class UserRegisterResponse{
    private final String message;
    public UserRegisterResponse(String message) {
        this.message = message;
    }

}
