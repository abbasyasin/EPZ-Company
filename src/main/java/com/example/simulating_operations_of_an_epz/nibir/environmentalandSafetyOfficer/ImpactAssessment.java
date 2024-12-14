package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

public class ImpactAssessment {
    private String projectName;
    private String location;
    private String description;

    public ImpactAssessment(String projectName, String location, String description) {
        this.projectName = projectName;
        this.location = location;
        this.description = description;
    }

    public String getProjectName() {
        return projectName;
    }


    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project Name: " + projectName + "\nLocation: " + location + "\nDescription: " + description;
    }
}
