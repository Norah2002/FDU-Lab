package com.lab3.response;

import lombok.Data;

@Data
public class GreetingResponse {
    private final long id;
    private final String name;
    public GreetingResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
