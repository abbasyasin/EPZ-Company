package com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;

public class Complaint {
    private String complaintID;
    private String companyName;
    private String issueDescription;
    private String dateOfComplaint;
    private String resolutionStatus;

    public Complaint(String complaintID, String companyName, String issueDescription, String dateOfComplaint, String resolutionStatus) {
        this.complaintID = complaintID;
        this.companyName = companyName;
        this.issueDescription = issueDescription;
        this.dateOfComplaint = dateOfComplaint;
        this.resolutionStatus = resolutionStatus;
    }
    public String getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(String complaintID) {
        this.complaintID = complaintID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getDateOfComplaint() {
        return dateOfComplaint;
    }

    public void setDateOfComplaint(String dateOfComplaint) {
        this.dateOfComplaint = dateOfComplaint;
    }

    public String getResolutionStatus() {
        return resolutionStatus;
    }

    public void setResolutionStatus(String resolutionStatus) {
        this.resolutionStatus = resolutionStatus;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintID='" + complaintID + '\'' +
                ", companyName='" + companyName + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", dateOfComplaint='" + dateOfComplaint + '\'' +
                ", resolutionStatus='" + resolutionStatus + '\'' +
                '}';
    }
}
