package com.example.simulating_operations_of_an_epz.nibir.directorofInfrastructureandDevelopment;

import java.time.LocalDate;

public class AnnualMaintenancePlan {
    private LocalDate date;
    private String maintenanceDetails;
    private String assignedTeam;

    public AnnualMaintenancePlan(LocalDate date, String maintenanceDetails, String assignedTeam) {
        this.date = date;
        this.maintenanceDetails = maintenanceDetails;
        this.assignedTeam = assignedTeam;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMaintenanceDetails() {
        return maintenanceDetails;
    }

    public void setMaintenanceDetails(String maintenanceDetails) {
        this.maintenanceDetails = maintenanceDetails;
    }

    public String getAssignedTeam() {
        return assignedTeam;
    }

    public void setAssignedTeam(String assignedTeam) {
        this.assignedTeam = assignedTeam;
    }
}
