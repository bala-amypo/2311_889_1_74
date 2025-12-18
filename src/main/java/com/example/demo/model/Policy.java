package com.example.demo.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
public class Policy{
    @Id
    private Long id;
    private 
    @Column(unique = true)
    private String policyNumber;
    private LocalDte startDate;
    private LocalDate endDate;

    public Policy(Long id, String policyNumber, LocalDte startDate, LocalDate endDate) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    public LocalDte getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDte startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}