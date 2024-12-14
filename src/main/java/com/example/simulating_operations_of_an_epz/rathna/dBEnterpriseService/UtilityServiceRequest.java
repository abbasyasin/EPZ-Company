package com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;

import java.time.LocalDate;

public class UtilityServiceRequest {
    private String utilityType;
    private String serviceLocation;
    private String contactInformation;
    private LocalDate startDate;

    public UtilityServiceRequest(String utilityType, String serviceLocation, String contactInformation, LocalDate startDate) {
        this.utilityType = utilityType;
        this.serviceLocation = serviceLocation;
        this.contactInformation = contactInformation;
        this.startDate = startDate;
    }

    public String getUtilityType() {
        return utilityType;
    }

    public void setUtilityType(String utilityType) {
        this.utilityType = utilityType;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "UtilityServiceRequest{" +
                "utilityType='" + utilityType + '\'' +
                ", serviceLocation='" + serviceLocation + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
