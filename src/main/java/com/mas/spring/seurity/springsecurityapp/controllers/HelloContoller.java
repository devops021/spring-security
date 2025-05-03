package com.mas.spring.seurity.springsecurityapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {

    @GetMapping("/hello")
    public String hello(){
        return "Spring security Rocks!!";
    }
}
