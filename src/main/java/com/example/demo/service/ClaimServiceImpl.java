package com.example.demo.service;

import com.example.demo.model.Claim;
import com.example.demo.repository.ClaimRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepo claimRepo;

    public ClaimServiceImpl(ClaimRepo claimRepo) {
        this.claimRepo = claimRepo;
    }

    @Override
    public Claim createClaim(Claim claim) {
        return claimRepo.save(claim);
    }

    @Override
    public Claim getClaim(Long id) {
        return claimRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepo.findAll();
    }
}
