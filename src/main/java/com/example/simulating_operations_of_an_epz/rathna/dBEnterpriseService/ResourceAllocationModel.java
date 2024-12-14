package com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;

import java.time.LocalDate;

public class ResourceAllocationModel {

    private String requestId;
    private String companyName;
    private String resourceRequest;
    private int quantity;
    private LocalDate submissionDate;
    private String priority;
    private String directorDecision;

    // Constructor
    public ResourceAllocationModel(String requestId, String companyName, String resourceRequest, int quantity, LocalDate submissionDate, String priority, String directorDecision) {
        this.requestId = requestId;
        this.companyName = companyName;
        this.resourceRequest = resourceRequest;
        this.quantity = quantity;
        this.submissionDate = submissionDate;
        this.priority = priority;
        this.directorDecision = directorDecision;
    }




    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getResourceRequest() {
        return resourceRequest;
    }

    public void setResourceRequest(String resourceRequest) {
        this.resourceRequest = resourceRequest;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDirectorDecision() {
        return directorDecision;
    }

    public void setDirectorDecision(String directorDecision) {
        this.directorDecision = directorDecision;
    }

    @Override
    public String toString() {
        return "ResourceAllocationModel{" +
                "requestId='" + requestId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", resourceRequest='" + resourceRequest + '\'' +
                ", quantity=" + quantity +
                ", submissionDate=" + submissionDate +
                ", priority='" + priority + '\'' +
                ", directorDecision='" + directorDecision + '\'' +
                '}';
    }
}
