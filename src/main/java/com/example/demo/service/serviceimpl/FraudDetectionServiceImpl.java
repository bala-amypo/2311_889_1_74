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
        // Fetch claim by ID or throw exception if not found
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id: " + claimId));

        List<FraudRule> rules = fraudRuleRepository.findAll();

        for (FraudRule rule : rules) {
            // Example: checking only claimAmount field
            if ("claimAmount".equals(rule.getConditionField())) {
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

        // If no rules matched
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
        List<FraudCheckResult> results = resultRepository.findByClaimId(claimId);

        if (results.isEmpty()) {
            throw new ResourceNotFoundException("No fraud check result found for claim id: " + claimId);
        }

        // Return the first result (you can modify if multiple results exist)
        return results.get(0);
    }
}
