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
    
}