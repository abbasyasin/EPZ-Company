package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import java.io.Serializable;

public class ThreatAssetment implements Serializable {
    private int threatId;
    private String threatType;
    private String riskLabel;
    private String describtion;

    public ThreatAssetment(int threatId, String threatType, String riskLabel, String describtion) {
        this.threatId = threatId;
        this.threatType = threatType;
        this.riskLabel = riskLabel;
        this.describtion = describtion;
    }

    public int getThreatId() {
        return threatId;
    }

    public void setThreatId(int threatId) {
        this.threatId = threatId;
    }

    public String getThreatType() {
        return threatType;
    }

    public void setThreatType(String threatType) {
        this.threatType = threatType;
    }

    public String getRiskLabel() {
        return riskLabel;
    }

    public void setRiskLabel(String riskLabel) {
        this.riskLabel = riskLabel;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }
}
