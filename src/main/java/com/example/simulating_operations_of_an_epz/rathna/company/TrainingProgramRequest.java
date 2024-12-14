package com.example.simulating_operations_of_an_epz.rathna.company;

import java.time.LocalDate;

public class TrainingProgramRequest {
    private String topic;
    private int employeeCount;
    private LocalDate startDate;

    public TrainingProgramRequest(String topic, int employeeCount, LocalDate startDate) {
        this.topic = topic;
        this.employeeCount = employeeCount;
        this.startDate = startDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "TrainingProgramRequest{" +
                "topic='" + topic + '\'' +
                ", employeeCount=" + employeeCount +
                ", startDate=" + startDate +
                '}';
    }
}
