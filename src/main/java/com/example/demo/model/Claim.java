package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Policy policy;

    @NotNull
    private LocalDate claimDate;

    @Positive
    private double claimAmount;

    private String status;

    @AssertTrue
    public boolean isAmountValid() {
        return claimAmount > 0;
    }

    // getters & setters
}
