package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.PolicyDto;
import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping("/{userId}")
    public Policy createPolicy(@PathVariable Long userId,
                               @RequestBody PolicyDto dto) {

        Policy policy = new Policy(
                null,
                dto.getPolicyNumber(),
                dto.getPolicyType(),
                dto.getStartDate(),
                dto.getEndDate()
        );

        return policyService.createPolicy(userId, policy);
    }

    @GetMapping("/user/{userId}")
    public List<Policy> getPoliciesByUser(@PathVariable Long userId) {
        return policyService.getPoliciesByUser(userId);
    }
}
