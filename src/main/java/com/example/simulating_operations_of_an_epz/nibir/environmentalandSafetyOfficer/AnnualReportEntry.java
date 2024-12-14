package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

public class AnnualReportEntry {
    private final String incidents;
    private final String safetyInspections;
    private final String recommendations;

    public AnnualReportEntry(String incidents, String safetyInspections, String recommendations) {
        this.incidents = incidents;
        this.safetyInspections = safetyInspections;
        this.recommendations = recommendations;
    }

    public String getIncidents() {
        return incidents;
    }

    public String getSafetyInspections() {
        return safetyInspections;
    }

    public String getRecommendations() {
        return recommendations;
    }
}
