package com.example.simulating_operations_of_an_epz.nibir.directorofInfrastructureandDevelopment;

public class InfrastructureProjectPlan {
    private String name;
    private String description;
    private String projectType;
    private String timeline;
    private String budget;

    public InfrastructureProjectPlan(String name, String description, String projectType, String timeline, String budget) {
        this.name = name;
        this.description = description;
        this.projectType = projectType;
        this.timeline = timeline;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
}