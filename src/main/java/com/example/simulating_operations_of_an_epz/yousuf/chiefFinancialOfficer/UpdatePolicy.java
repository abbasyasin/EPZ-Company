package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import java.io.Serializable;
import java.time.LocalDate;

public class UpdatePolicy implements Serializable {
    private int policyId;
    private String policyTitle;
    private  String policyDescription;
    private LocalDate date;

    public UpdatePolicy(int policyId, String policyTitle, String policyDescription, LocalDate date) {
        this.policyId = policyId;
        this.policyTitle = policyTitle;
        this.policyDescription = policyDescription;
        this.date = date;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }

    public String getPolicyDescription() {
        return policyDescription;
    }

    public void setPolicyDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
