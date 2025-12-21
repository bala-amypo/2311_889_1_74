package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_check_results")
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    private Boolean isFraudulent;

    private String triggeredRuleName;

    private String rejectionReason;

    private LocalDateTime checkedAt;

    public FraudCheckResult() {
    }

    public FraudCheckResult(Claim claim, Boolean isFraudulent,
                            String triggeredRuleName,
                            String rejectionReason,
                            LocalDateTime checkedAt) {
        this.claim = claim;
        this.isFraudulent = isFraudulent;
        this.triggeredRuleName = triggeredRuleName;
        this.rejectionReason = rejectionReason;
        this.checkedAt = checkedAt;
    }

    @PrePersist
    public void onCreate() {
        this.checkedAt = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public Claim getClaim() {
        return claim;
    }

    public Boolean getIsFraudulent() {
        return isFraudulent;
    }

    public String getTriggeredRuleName() {
        return triggeredRuleName;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }
}
