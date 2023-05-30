package com.lab3.response;

import lombok.Data;

@Data
public class UserLoginResponse {
    private final String message;
    public UserLoginResponse(String message){
        this.message = message;
    }
}
