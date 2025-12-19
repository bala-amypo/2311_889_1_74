package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Studententity;

@Service
public class PolicySerivce {
    Map<Integer,Policy> mp = new HashMap<>();

       public Policy id(int id) {
        return mp.get(id);
    }


}