package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.FraudRule;

public interface FraudRuleRepository extends JpaRepository<FraudRule, Long> {

    Optional<FraudRule> findByRuleName(String ruleName); // ✅ ADD
}
