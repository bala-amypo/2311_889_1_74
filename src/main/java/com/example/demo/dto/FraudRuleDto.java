package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class FraudRuleDto {

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

    public FraudRuleDto() {}

    public FraudRuleDto(String ruleName, String conditionField, String operator, String value, String severity) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }

    // Getters and Setters
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getConditionField() { return conditionField; }
    public void setConditionField(String conditionField) { this.conditionField = conditionField; }

    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
}
