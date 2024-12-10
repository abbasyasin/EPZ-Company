package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import java.io.Serializable;
import java.time.LocalDate;

public class NetworkingEvent implements Serializable {
    private String eventName;
    private LocalDate date;
    private String venue;
    private int expectedParticipants;
    private String description;

    public NetworkingEvent(String eventName, LocalDate date, String venue, int expectedParticipants, String description) {
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
        this.expectedParticipants = expectedParticipants;
        this.description = description;
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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getExpectedParticipants() {
        return expectedParticipants;
    }

    public void setExpectedParticipants(int expectedParticipants) {
        this.expectedParticipants = expectedParticipants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
