package com.example.demo.model;

import java.time.LocalDateTime;

public class FraudCheckResult{
    private Long id;
    private Boolean isFraudulent;
    private String triggeredRuleName;
    private String rejectionReason;
    private LocalDateTime checkedAt;
    public FraudCheckResult(Long id, Boolean isFraudulent, String triggeredRuleName, String rejectionReason,
            LocalDateTime checkedAt) {
        this.id = id;
        this.isFraudulent = isFraudulent;
        this.triggeredRuleName = triggeredRuleName;
        this.rejectionReason = rejectionReason;
        this.checkedAt = checkedAt;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getIsFraudulent() {
        return isFraudulent;
    }
    public void setIsFraudulent(Boolean isFraudulent) {
        this.isFraudulent = isFraudulent;
    }
    public String getTriggeredRuleName() {
        return triggeredRuleName;
    }
    public void setTriggeredRuleName(String triggeredRuleName) {
        this.triggeredRuleName = triggeredRuleName;
    }
    public String getRejectionReason() {
        return rejectionReason;
    }
    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }
    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }
    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }
    
}