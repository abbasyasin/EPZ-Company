package com.example.simulating_operations_of_an_epz.rathna.company;


import java.io.Serializable;
import java.time.LocalDate;

public class UtilityRequest implements Serializable {
    private  String proposalName;
    private String utilityType;
    private  String requiredAmount;
    private LocalDate  startDate;

    public UtilityRequest(String proposalName, String utilityType, String requiredAmount, LocalDate startDate) {
        this.proposalName = proposalName;
        this.utilityType = utilityType;
        this.requiredAmount = requiredAmount;
        this.startDate = startDate;
    }

    public String getProposalName() {
        return proposalName;
    }

    public void setProposalName(String proposalName) {
        this.proposalName = proposalName;
    }

    public String getUtilityType() {
        return utilityType;
    }

    public void setUtilityType(String utilityType) {
        this.utilityType = utilityType;
    }

    public String getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(String requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "UtilityRequest{" +
                "proposalName='" + proposalName + '\'' +
                ", utilityType='" + utilityType + '\'' +
                ", requiredAmount='" + requiredAmount + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
