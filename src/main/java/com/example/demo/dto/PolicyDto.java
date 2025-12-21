package com.example.demo.dto;

import java.time.LocalDate;

public class PolicyDto {

    private String policyNumber;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
