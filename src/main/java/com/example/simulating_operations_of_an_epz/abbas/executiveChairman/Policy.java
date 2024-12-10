package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import java.io.Serializable;
import java.time.LocalDate;

public class Policy implements Serializable {
    private String policyName;
    private String description;
    private LocalDate effectiveDate;

    public Policy(String policyName, String description, LocalDate effectiveDate) {
        this.policyName = policyName;
        this.description = description;
        this.effectiveDate = effectiveDate;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
