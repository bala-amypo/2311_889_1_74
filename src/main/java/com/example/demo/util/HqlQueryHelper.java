package com.example.demo.util;

import com.example.demo.model.Claim;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HqlQueryHelper {
    
    public String buildClaimQuery(String status) {
        StringBuilder query = new StringBuilder("SELECT c FROM Claim c");
        if (status != null && !status.isEmpty()) {
            query.append(" WHERE c.status = :status");
        }
        return query.toString();
    }
    
    public String buildPolicyQuery(String policyType) {
        StringBuilder query = new StringBuilder("SELECT p FROM Policy p");
        if (policyType != null && !policyType.isEmpty()) {
            query.append(" WHERE p.policyType = :policyType");
        }
        return query.toString();
    }
    
    public String buildFraudRuleQuery(String severity) {
        StringBuilder query = new StringBuilder("SELECT fr FROM FraudRule fr");
        if (severity != null && !severity.isEmpty()) {
            query.append(" WHERE fr.severity = :severity");
        }
        return query.toString();
    }
    
    public List<Claim> findHighValueClaims(Double minAmount) {
        return List.of();
    }
    
    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {
        return List.of();
    }
}