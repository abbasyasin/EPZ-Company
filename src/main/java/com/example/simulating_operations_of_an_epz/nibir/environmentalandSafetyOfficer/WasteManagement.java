package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

public class WasteManagement {
    private String companyName;
    private String wasteType;
    private String violation;
    private String sendWarning;

    public WasteManagement(String companyName, String wasteType, String violation, String sendWarning) {
        this.companyName = companyName;
        this.wasteType = wasteType;
        this.violation = violation;
        this.sendWarning = sendWarning;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getViolation() {
        return violation;
    }

    public void setViolation(String violation) {
        this.violation = violation;
    }

    public String getSendWarning() {
        return sendWarning;
    }

    public void setSendWarning(String sendWarning) {
        this.sendWarning = sendWarning;
    }

    @Override
    public String toString() {
        return "Company Name: " + companyName +
                "\nWaste Type: " + wasteType +
                "\nViolation: " + violation +
                "\nSend Warning: " + sendWarning;
    }
}
