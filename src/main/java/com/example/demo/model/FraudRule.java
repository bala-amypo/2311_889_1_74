package com.example.demo.model;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "fraud_rules")
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String conditionField;

    private String operator;

    private String value;

    private String severity;

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims;

    public FraudRule() {
    }

    public FraudRule(String ruleName, String conditionField,
                     String operator, String value, String severity) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }


    public Long getId() {
        return id;
    }

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

    public Set<Claim> getClaims() {
        return claims;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setConditionField(String conditionField) {
        this.conditionField = conditionField;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setClaims(Set<Claim> claims) {
        this.claims = claims;
    }
}
