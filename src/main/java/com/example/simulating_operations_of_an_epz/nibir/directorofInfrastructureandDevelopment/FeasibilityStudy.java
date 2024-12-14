package com.example.simulating_operations_of_an_epz.nibir.directorofInfrastructureandDevelopment;

public class FeasibilityStudy {
    private String projectScope;
    private String timeline;
    private String budget;

    public FeasibilityStudy(String projectScope, String timeline, String budget) {
        this.projectScope = projectScope;
        this.timeline = timeline;
        this.budget = budget;
    }

    public String getProjectScope() {
        return projectScope;
    }

    public void setProjectScope(String projectScope) {
        this.projectScope = projectScope;
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
