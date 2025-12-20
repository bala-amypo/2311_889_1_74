package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public Claim create(@Valid @RequestBody Claim claim) {
        return claimService.createClaim(claim);
    }

    @GetMapping("/{id}")
    public Claim get(@PathVariable Long id) {
        return claimService.getClaim(id);
    }

    @GetMapping
    public List<Claim> all() {
        return claimService.getAllClaims();
    }
}
