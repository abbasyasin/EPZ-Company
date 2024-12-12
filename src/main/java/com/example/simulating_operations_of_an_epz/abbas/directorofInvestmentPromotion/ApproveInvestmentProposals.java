package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import java.io.Serializable;

public class ApproveInvestmentProposals extends DummyInvestmentProposals implements Serializable {
    private String approveInvestmentProposal;

    public ApproveInvestmentProposals(String investmentTitle, double investmentAmount, String companyName, String projectDescription, String documents, String approveInvestmentProposal) {
        super(investmentTitle, investmentAmount, companyName, projectDescription, documents);
        this.approveInvestmentProposal = approveInvestmentProposal;
    }

    public String getApproveInvestmentProposal() {
        return approveInvestmentProposal;
    }

    public void setApproveInvestmentProposal(String approveInvestmentProposal) {
        this.approveInvestmentProposal = approveInvestmentProposal;
    }
}
