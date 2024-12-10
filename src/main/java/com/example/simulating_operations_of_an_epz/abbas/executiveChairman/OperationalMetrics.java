package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import java.io.Serializable;
import java.time.LocalDate;

public class OperationalMetrics implements Serializable {
    private String metricType;
    private String metricName;
    private double metricValue;
    private LocalDate startDate;
    private LocalDate endDate;

    public OperationalMetrics(String metricType, String metricName, double metricValue, LocalDate startDate, LocalDate endDate) {
        this.metricType = metricType;
        this.metricName = metricName;
        this.metricValue = metricValue;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getMetricType() {
        return metricType;
    }

    public void setMetricType(String metricType) {
        this.metricType = metricType;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public double getMetricValue() {
        return metricValue;
    }

    public void setMetricValue(double metricValue) {
        this.metricValue = metricValue;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "OperationalMetrics{" +
                "metricType='" + metricType + '\'' +
                ", metricName='" + metricName + '\'' +
                ", metricValue=" + metricValue +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
