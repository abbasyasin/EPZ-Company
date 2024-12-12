package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import java.io.Serializable;

public class InvestorPerformance extends ApproveInvestmentProposals implements Serializable {
    private String performanceRating;

    public InvestorPerformance(String investmentTitle, double investmentAmount, String companyName, String projectDescription, String documents, String approveInvestmentProposal, String performanceRating) {
        super(investmentTitle, investmentAmount, companyName, projectDescription, documents, approveInvestmentProposal);
        this.performanceRating = performanceRating;
    }

    public String getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(String performanceRating) {
        this.performanceRating = performanceRating;
    }
}
