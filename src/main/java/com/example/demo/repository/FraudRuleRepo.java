package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FraudRule;

public interface FraudRuleRepo extends JpaRepository<FraudRule, Long> {

    boolean existsByRuleName(String ruleName);
}
