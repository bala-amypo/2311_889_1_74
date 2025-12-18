package com.example.demo.controller;

import org.springframework.beans.factory.BeanRegistry.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PolicyController {
    @Autowired
    Policy src;
    @PostMapping("/post")
    public Policy postdata(@RequestBody Policy st){
        return src.savedata(st);
    }

    @GetMapping("/user/{userId}")
    public Policy getIdVal(@PathVariable int id){
        return src.id(id);
    }
    
}
