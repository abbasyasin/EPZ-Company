package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

import java.time.LocalDate;

public class TrainingSchedule {
    private String topic;
    private String targetAudience;
    private LocalDate date;

    public TrainingSchedule(String topic, String targetAudience, LocalDate date) {
        this.topic = topic;
        this.targetAudience = targetAudience;
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TrainingSchedule{" +
                "topic='" + topic + '\'' +
                ", targetAudience='" + targetAudience + '\'' +
                ", date=" + date +
                '}';
    }
}
