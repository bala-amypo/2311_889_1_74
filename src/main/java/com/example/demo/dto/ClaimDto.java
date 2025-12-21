package com.example.demo.dto;

import java.time.LocalDate;

public class ClaimDto {

    private LocalDate claimDate;
    private Double claimAmount;
    private String description;

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public String getDescription() {
        return description;
    }
}
