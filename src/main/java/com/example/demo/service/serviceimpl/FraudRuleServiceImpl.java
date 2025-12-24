package com.example.demo.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

@Service   // 🔴 REQUIRED
public class FraudRuleServiceImpl implements FraudRuleService {

    @Autowired
    private FraudRuleRepository fraudRuleRepository;

    @Override
    public FraudRule addRule(FraudRule rule) {
        return fraudRuleRepository.save(rule); // 🔴 REQUIRED
    }

    @Override
    public List<FraudRule> getAllRules() {
        return fraudRuleRepository.findAll();
    }
}
