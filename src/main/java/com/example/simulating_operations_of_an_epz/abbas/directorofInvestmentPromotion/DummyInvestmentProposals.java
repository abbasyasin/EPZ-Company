package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import java.io.Serializable;

public class DummyInvestmentProposals implements Serializable {
    private String investmentTitle;
    private double investmentAmount;
    private String CompanyName;
    private String projectDescription;
    private String documents;

    public DummyInvestmentProposals(String investmentTitle, double investmentAmount, String companyName, String projectDescription, String documents) {
        this.investmentTitle = investmentTitle;
        this.investmentAmount = investmentAmount;
        CompanyName = companyName;
        this.projectDescription = projectDescription;
        this.documents = documents;
    }

    public String getInvestmentTitle() {
        return investmentTitle;
    }

    public void setInvestmentTitle(String investmentTitle) {
        this.investmentTitle = investmentTitle;
    }

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }
}
