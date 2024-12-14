package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

public class SafetyInspection {
    private String companyName;
    private String inspectionDate;
    private String violations;

    public SafetyInspection(String companyName, String inspectionDate, String violations) {
        this.companyName = companyName;
        this.inspectionDate = inspectionDate;
        this.violations = violations;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getViolations() {
        return violations;
    }

    public void setViolations(String violations) {
        this.violations = violations;
    }

    @Override
    public String toString() {
        return "Company Name: " + companyName + "\nInspection Date: " + inspectionDate + "\nViolations: " + violations;
    }
}
