  package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FraudCheckResult;

public interface FraudCheckResultRepo extends JpaRepository<FraudCheckResult, Long> {

    Optional<FraudCheckResult> findByClaimId(Long claimId);
}
