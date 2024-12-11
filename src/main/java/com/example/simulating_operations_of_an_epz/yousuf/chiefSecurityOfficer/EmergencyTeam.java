package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import java.io.Serializable;

public class EmergencyTeam implements Serializable {
    private int planId;
    private String emergencyType;
    private String mobileNumber;
    private String responseTeamMember;

    public EmergencyTeam(int planId, String emergencyType, String mobileNumber, String responseTeamMember) {
        this.planId = planId;
        this.emergencyType = emergencyType;
        this.mobileNumber = mobileNumber;
        this.responseTeamMember = responseTeamMember;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getResponseTeamMember() {
        return responseTeamMember;
    }

    public void setResponseTeamMember(String responseTeamMember) {
        this.responseTeamMember = responseTeamMember;
    }
}
