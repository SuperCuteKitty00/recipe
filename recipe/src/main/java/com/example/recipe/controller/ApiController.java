package com.example.recipe.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
