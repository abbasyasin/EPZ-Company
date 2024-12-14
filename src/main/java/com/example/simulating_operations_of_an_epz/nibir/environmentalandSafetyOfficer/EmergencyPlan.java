package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

public class EmergencyPlan {
    private String emergencyContacts;
    private String responseSteps;

    public EmergencyPlan(String emergencyContacts, String responseSteps) {
        this.emergencyContacts = emergencyContacts;
        this.responseSteps = responseSteps;
    }

    public String getEmergencyContacts() {
        return emergencyContacts;
    }

    public void setEmergencyContacts(String emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    public String getResponseSteps() {
        return responseSteps;
    }

    public void setResponseSteps(String responseSteps) {
        this.responseSteps = responseSteps;
    }

    @Override
    public String toString() {
        return "\nEmergency Contacts: " + emergencyContacts + "\nResponse Steps: " + responseSteps;
    }
}
