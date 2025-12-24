package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String ruleName;

    @NotBlank
    private String conditionField;

    @NotBlank
    private String operator;

    @NotBlank
    private String value;

    @NotBlank
    private String severity;

    public FraudRule() {}

    public FraudRule(String ruleName, String conditionField, String operator,
                     String value, String severity) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }

    // getters & setters
}
