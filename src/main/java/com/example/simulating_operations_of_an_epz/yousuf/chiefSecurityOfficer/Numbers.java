package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

public class Numbers {
    private String fireServiceNumber;
    private String emergencyNumber;
    private String dutyOfficer;
    private String chairman;
    private String policeNumber;

    public Numbers(String fireServiceNumber, String emergencyNumber, String dutyOfficer, String chairman, String policeNumber) {
        this.fireServiceNumber = fireServiceNumber;
        this.emergencyNumber = emergencyNumber;
        this.dutyOfficer = dutyOfficer;
        this.chairman = chairman;
        this.policeNumber = policeNumber;
    }

    public String getFireServiceNumber() {
        return fireServiceNumber;
    }

    public void setFireServiceNumber(String fireServiceNumber) {
        this.fireServiceNumber = fireServiceNumber;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getDutyOfficer() {
        return dutyOfficer;
    }

    public void setDutyOfficer(String dutyOfficer) {
        this.dutyOfficer = dutyOfficer;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public String getPoliceNumber() {
        return policeNumber;
    }

    public void setPoliceNumber(String policeNumber) {
        this.policeNumber = policeNumber;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "fireServiceNumber='" + fireServiceNumber + '\'' +
                ", emergencyNumber='" + emergencyNumber + '\'' +
                ", dutyOfficer='" + dutyOfficer + '\'' +
                ", chairman='" + chairman + '\'' +
                ", policeNumber='" + policeNumber + '\'' +
                '}';
    }
}
