package com.example.demo.controller;

import com.example.demo.dto.PolicyDto;
import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    
    private final PolicyService policyService;
    
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }
    
    @PostMapping("/{userId}")
    public ResponseEntity<?> createPolicy(@PathVariable Long userId, @RequestBody PolicyDto policyDto) {
        try {
            if (policyDto.getPolicyNumber() == null || policyDto.getPolicyType() == null) {
                return ResponseEntity.badRequest().body("Policy number and type are required");
            }
            
            Policy policy = new Policy(null, policyDto.getPolicyNumber(), policyDto.getPolicyType(), 
                                     policyDto.getStartDate(), policyDto.getEndDate());
            Policy savedPolicy = policyService.createPolicy(userId, policy);
            return ResponseEntity.ok(savedPolicy);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create policy");
        }
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getPoliciesByUser(@PathVariable Long userId) {
        try {
            List<Policy> policies = policyService.getPoliciesByUser(userId);
            return ResponseEntity.ok(policies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or no policies available");
        }
    }
}