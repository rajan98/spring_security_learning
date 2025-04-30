package com.eazybytes.springsecsection1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String sayWelcome(){
        return "Welcome to spring without security";
    }
}
