package com.example.simulating_operations_of_an_epz.nibir.directorofInfrastructureandDevelopment;

import java.time.LocalDate;

public class InfrastructureProject {
    private String projectID;
    private String projectName;
    private String status;
    private LocalDate updateDate;

    public InfrastructureProject(String projectID, String projectName, String status, LocalDate updateDate) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.status = status;
        this.updateDate = updateDate;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}
