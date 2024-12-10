package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import java.io.Serializable;
import java.time.LocalDate;

public class IncidentReport implements Serializable {
    private int incidentId;
    private String incidentType;
    private LocalDate date;
    private String reportedBy;

    public IncidentReport(int incidentId, String incidentType, LocalDate date, String reportedBy) {
        this.incidentId = incidentId;
        this.incidentType = incidentType;
        this.date = date;
        this.reportedBy = reportedBy;
    }

    public int getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }
}
