package com.example.demo.controller;

import org.springframework.beans.factory.BeanRegistry.Spec;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class AuthController {

    @PostMapping("/register")
    public User postdata(@RequestBody User st){
        return src.savedata(st);
    }

    @PostMapping("/login"){
        public User postdata(@RequestBody User st){
            return src.savedata(st);
        }
    }    
}
