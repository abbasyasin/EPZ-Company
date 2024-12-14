package com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;

public class Document {
    private String companyName;
    private String permit;
    private String businessPlan;

    public Document(String companyName, String permit, String businessPlan) {
        this.companyName = companyName;
        this.permit = permit;
        this.businessPlan = businessPlan;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getBusinessPlan() {
        return businessPlan;
    }

    public void setBusinessPlan(String businessPlan) {
        this.businessPlan = businessPlan;
    }

    @Override
    public String toString() {
        return "Document{" +
                "companyName='" + companyName + '\'' +
                ", permit='" + permit + '\'' +
                ", businessPlan='" + businessPlan + '\'' +
                '}';
    }
}
