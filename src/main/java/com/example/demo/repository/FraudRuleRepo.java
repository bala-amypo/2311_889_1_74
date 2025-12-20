package com.example.demo.repository;

import com.example.demo.model.FraudRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRuleRepo extends JpaRepository<FraudRule, Long> {
}
