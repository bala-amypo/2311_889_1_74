package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    @Autowired
    private FraudRuleRepository repository;

    @Override
    public FraudRule addRule(FraudRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }
}
