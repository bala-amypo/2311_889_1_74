package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Claim;

public interface ClaimService {

    Claim createClaim(Long policyId, Claim claim);

    Claim getClaim(Long claimId);

    List<Claim> getAllClaims();
}
