package com.example.demo.dto;

public class FraudRuleDto {

    private String ruleName;
    private String conditionField;
    private String operator;
    private String value;
    private String severity;

    public String getRuleName() {
        return ruleName;
    }

    public String getConditionField() {
        return conditionField;
    }

    public String getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }

    public String getSeverity() {
        return severity;
    }
}
