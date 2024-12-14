package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

public class AirQualityEntry {
    private String companyName;
    private String pollutionLevels;
    private String sendWarning;
    private String issueFine;

    public AirQualityEntry(String companyName, String pollutionLevels, String sendWarning, String issueFine) {
        this.companyName = companyName;
        this.pollutionLevels = pollutionLevels;
        this.sendWarning = sendWarning;
        this.issueFine = issueFine;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPollutionLevels() {
        return pollutionLevels;
    }

    public void setPollutionLevels(String pollutionLevels) {
        this.pollutionLevels = pollutionLevels;
    }

    public String getSendWarning() {
        return sendWarning;
    }

    public void setSendWarning(String sendWarning) {
        this.sendWarning = sendWarning;
    }

    public String getIssueFine() {
        return issueFine;
    }

    public void setIssueFine(String issueFine) {
        this.issueFine = issueFine;
    }

    @Override
    public String toString() {
        return "Company Name: " + companyName +
                "\nPollution Levels: " + pollutionLevels +
                "\nSend Warning: " + sendWarning +
                "\nIssue Fine: " + issueFine;
    }
}
