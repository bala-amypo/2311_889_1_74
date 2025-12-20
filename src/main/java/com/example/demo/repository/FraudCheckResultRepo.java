package com.example.demo.repository;

import com.example.demo.model.FraudCheckResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckResultRepo extends JpaRepository<FraudCheckResult, Long> {
}
