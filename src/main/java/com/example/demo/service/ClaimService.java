package com.example.demo.service;

import com.example.demo.model.Claim;

import java.util.List;

public interface ClaimService {

    Claim createClaim(Claim claim);

    Claim getClaimById(Long id);

    List<Claim> getAllClaims();
}
