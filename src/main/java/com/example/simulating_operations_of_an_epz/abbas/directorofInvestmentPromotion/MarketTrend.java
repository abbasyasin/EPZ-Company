package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import java.io.Serializable;

public class MarketTrend implements Serializable {
    private String trendName;
    private String affectedSector;
    private String impactLevel;
    private String description;

    public MarketTrend(String trendName, String affectedSector, String impactLevel, String description) {
        this.trendName = trendName;
        this.affectedSector = affectedSector;
        this.impactLevel = impactLevel;
        this.description = description;
    }

    public String getTrendName() {
        return trendName;
    }

    public void setTrendName(String trendName) {
        this.trendName = trendName;
    }

    public String getAffectedSector() {
        return affectedSector;
    }

    public void setAffectedSector(String affectedSector) {
        this.affectedSector = affectedSector;
    }

    public String getImpactLevel() {
        return impactLevel;
    }

    public void setImpactLevel(String impactLevel) {
        this.impactLevel = impactLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
