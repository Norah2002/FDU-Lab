package com.lab3.controller;

import com.lab3.response.GreetingResponse;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello, World!";
    }
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public @ResponseBody GreetingResponse greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new GreetingResponse(counter.incrementAndGet(), "Hello, " + name + "!");
    }
}
