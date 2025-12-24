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

    // REQUIRED by JPA
    public FraudRule() {}

    public FraudRule(String ruleName,
                     String conditionField,
                     String operator,
                     String value,
                     String severity) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }

    // getters & setters
    public Long getId() { return id; }
    public String getRuleName() { return ruleName; }
    public String getConditionField() { return conditionField; }
    public String getOperator() { return operator; }
    public String getValue() { return value; }
    public String getSeverity() { return severity; }

    public void setId(Long id) { this.id = id; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public void setConditionField(String conditionField) { this.conditionField = conditionField; }
    public void setOperator(String operator) { this.operator = operator; }
    public void setValue(String value) { this.value = value; }
    public void setSeverity(String severity) { this.severity = severity; }
}
