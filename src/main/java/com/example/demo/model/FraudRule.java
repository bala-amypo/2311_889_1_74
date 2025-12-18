package com.example.demo.model;
import 
public class FraudRule{
    @Id
    private Long id;
    private String ruleName;
    private String conditionField;
    private String value;
    private String LOW;
    private String MEDIUM;
    private String HIGH;
    
    public FraudRule(Long id, String ruleName, String conditionField, String value, String lOW, String mEDIUM,
            String hIGH) {
        this.id = id;
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.value = value;
        LOW = lOW;
        MEDIUM = mEDIUM;
        HIGH = hIGH;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getConditionField() {
        return conditionField;
    }
    public void setConditionField(String conditionField) {
        this.conditionField = conditionField;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getLOW() {
        return LOW;
    }
    public void setLOW(String lOW) {
        LOW = lOW;
    }
    public String getMEDIUM() {
        return MEDIUM;
    }
    public void setMEDIUM(String mEDIUM) {
        MEDIUM = mEDIUM;
    }
    public String getHIGH() {
        return HIGH;
    }
    public void setHIGH(String hIGH) {
        HIGH = hIGH;
    }
    
}