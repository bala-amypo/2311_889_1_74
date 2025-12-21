package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ClaimDto;
import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping("/{policyId}")
    public Claim createClaim(@PathVariable Long policyId,
                             @RequestBody ClaimDto dto) {

        Claim claim = new Claim(
                null,
                dto.getClaimDate(),
                dto.getClaimAmount(),
                dto.getDescription()
        );

        return claimService.createClaim(policyId, claim);
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return claimService.getClaim(id);
    }

    @GetMapping
    public List<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }
}
