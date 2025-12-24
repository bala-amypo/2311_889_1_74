package com.example.demo.controller;

import com.example.demo.dto.ClaimDto;
import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    
    private final ClaimService claimService;
    
    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }
    
    @PostMapping("/{policyId}")
    public ResponseEntity<?> createClaim(@PathVariable Long policyId, @RequestBody ClaimDto claimDto) {
        try {
            if (claimDto.getClaimAmount() == null || claimDto.getDescription() == null) {
                return ResponseEntity.badRequest().body("Claim amount and description are required");
            }
            
            Claim claim = new Claim(null, claimDto.getClaimDate(), claimDto.getClaimAmount(), claimDto.getDescription());
            claim.setStatus("PENDING");
            Claim savedClaim = claimService.createClaim(policyId, claim);
            return ResponseEntity.ok(savedClaim);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create claim");
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getClaim(@PathVariable Long id) {
        try {
            Claim claim = claimService.getClaim(id);
            return ResponseEntity.ok(claim);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Claim not found");
        }
    }
    
    @GetMapping
    public ResponseEntity<?> getAllClaims() {
        try {
            List<Claim> claims = claimService.getAllClaims();
            return ResponseEntity.ok(claims);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve claims");
        }
    }
}