package com.example.simulating_operations_of_an_epz.rathna.company;

import java.time.LocalDate;

public class FeedbackModel {
    private String issueEncountered;
    private String serviceQuality;
    private LocalDate feedbackDate;

    public FeedbackModel(String issueEncountered, String serviceQuality, LocalDate feedbackDate) {
        this.issueEncountered = issueEncountered;
        this.serviceQuality = serviceQuality;
        this.feedbackDate = feedbackDate;
    }

    public String getIssueEncountered() {
        return issueEncountered;
    }

    public void setIssueEncountered(String issueEncountered) {
        this.issueEncountered = issueEncountered;
    }

    public String getServiceQuality() {
        return serviceQuality;
    }

    public void setServiceQuality(String serviceQuality) {
        this.serviceQuality = serviceQuality;
    }

    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDate feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    @Override
    public String toString() {
        return "FeedbackModel{" +
                "issueEncountered='" + issueEncountered + '\'' +
                ", serviceQuality='" + serviceQuality + '\'' +
                ", feedbackDate=" + feedbackDate +
                '}';
    }
}
