package com.example.demo.model;
import java.time.LocalDate;
import jakarte.persistence.Id;

public class Claim{
    @Id
    private Long id;
    private LocalDate claimDate;
    @PostiveOrZero
    private Double claimAmount;
    private String description;
    private String PENDING;
    private String APPROVED;
    private String REJECTED;

    public Claim(Long id, LocalDate claimDate, Double claimAmount, String description, String pENDING, String aPPROVED,
            String rEJECTED) {
        this.id = id;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
        PENDING = pENDING;
        APPROVED = aPPROVED;
        REJECTED = rEJECTED;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getClaimDate() {
        return claimDate;
    }
    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }
    public Double getClaimAmount() {
        return claimAmount;
    }
    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPENDING() {
        return PENDING;
    }
    public void setPENDING(String pENDING) {
        PENDING = pENDING;
    }
    public String getAPPROVED() {
        return APPROVED;
    }
    public void setAPPROVED(String aPPROVED) {
        APPROVED = aPPROVED;
    }
    public String getREJECTED() {
        return REJECTED;
    }
    public void setREJECTED(String rEJECTED) {
        REJECTED = rEJECTED;
    }

}