package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudCheckResultRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudDetectionService;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepository;
    private final FraudRuleRepository fraudRuleRepository;
    private final FraudCheckResultRepository resultRepository;

    public FraudDetectionServiceImpl(ClaimRepository claimRepository,
                                     FraudRuleRepository fraudRuleRepository,
                                     FraudCheckResultRepository resultRepository) {
        this.claimRepository = claimRepository;
        this.fraudRuleRepository = fraudRuleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public FraudCheckResult evaluateClaim(Long claimId) {

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Claim not found"));

        List<FraudRule> rules = fraudRuleRepository.findAll();

        for (FraudRule rule : rules) {
            if (rule.getConditionField().equals("claimAmount")) {

                double threshold = Double.parseDouble(rule.getValue());

                if (claim.getClaimAmount() > threshold) {
                    FraudCheckResult result = new FraudCheckResult(
                            claim,
                            true,
                            rule.getRuleName(),
                            "Claim amount exceeds threshold",
                            LocalDateTime.now()
                    );
                    return resultRepository.save(result);
                }
            }
        }

        FraudCheckResult result = new FraudCheckResult(
                claim,
                false,
                null,
                "No fraud detected",
                LocalDateTime.now()
        );

        return resultRepository.save(result);
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepository.findByClaimId(claimId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Result not found"));
    }
}
