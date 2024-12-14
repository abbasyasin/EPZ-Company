package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

import java.time.LocalDate;

public class IncidentReport {
    private String location;
    private String incidentType;
    private String severityLevel;
    private LocalDate date;
    private String description;

    public IncidentReport(String location, String incidentType, String severityLevel, LocalDate date, String description) {
        this.location = location;
        this.incidentType = incidentType;
        this.severityLevel = severityLevel;
        this.date = date;
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
