package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import java.io.Serializable;

public class PotentialInvestor implements Serializable {
    private String name;
    private String organization;
    private String investmentInterest;
    private String contactInfo;

    public PotentialInvestor(String name, String organization, String investmentInterest, String contactInfo) {
        this.name = name;
        this.organization = organization;
        this.investmentInterest = investmentInterest;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getInvestmentInterest() {
        return investmentInterest;
    }

    public void setInvestmentInterest(String investmentInterest) {
        this.investmentInterest = investmentInterest;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
