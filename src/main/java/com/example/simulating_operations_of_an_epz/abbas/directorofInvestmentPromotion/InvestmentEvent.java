package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import java.io.Serializable;
import java.time.LocalDate;

public class InvestmentEvent implements Serializable {
    private String eventName;
    private LocalDate date;
    private String location;
    private double budget;
    private String description;
    private String eventType;
    private String isPublic;

    public InvestmentEvent(String eventName, LocalDate date, String location, double budget, String description, String eventType, String isPublic) {
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.budget = budget;
        this.description = description;
        this.eventType = eventType;
        this.isPublic = isPublic;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }
}
