package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import java.io.Serializable;
import java.time.LocalDate;

public class MarketingCampaign implements Serializable {
    private String campaignName;
    private String targetAudience;
    private double budget;
    private LocalDate startDate;
    private LocalDate endDate;

    public MarketingCampaign(String campaignName, String targetAudience, double budget, LocalDate startDate, LocalDate endDate) {
        this.campaignName = campaignName;
        this.targetAudience = targetAudience;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
