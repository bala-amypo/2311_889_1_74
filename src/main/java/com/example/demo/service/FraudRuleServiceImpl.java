package com.example.demo.service;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudRuleServiceImpl {

    private final FraudRuleRepo repo;

    public FraudRuleServiceImpl(FraudRuleRepo repo) {
        this.repo = repo;
    }

    public FraudRule create(FraudRule rule) {
        return repo.save(rule);
    }

    public List<FraudRule> getAll() {
        return repo.findAll();
    }
}
