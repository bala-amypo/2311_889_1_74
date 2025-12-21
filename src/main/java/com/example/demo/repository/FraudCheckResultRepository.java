package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.FraudCheckResult;

public interface FraudCheckResultRepository
        extends JpaRepository<FraudCheckResult, Long> {

    List<FraudCheckResult> findByClaimId(Long claimId); // ✅ ADD
}
