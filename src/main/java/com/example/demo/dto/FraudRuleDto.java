package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class FraudRuleDto {

    @NotBlank
    private String ruleName;
    private String conditionField;
    private String operator;
    private String value;
    private String severity;

    // getters & setters
}
