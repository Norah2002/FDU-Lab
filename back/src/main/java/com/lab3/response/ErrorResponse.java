package com.lab3.response;

import lombok.Data;

@Data
public class ErrorResponse{
    private final String message;
    public ErrorResponse(String message) {
        this.message = message;
    }

}
