package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import java.io.Serializable;
import java.time.LocalDate;

public class KPI implements Serializable {
    private  String kpiName;
    private String description;
    private double targetValue;
    private double actualValue;
    private LocalDate date;

    public KPI(String kpiName, String description, double targetValue, double actualValue, LocalDate date) {
        this.kpiName = kpiName;
        this.description = description;
        this.targetValue = targetValue;
        this.actualValue = actualValue;
        this.date = date;
    }

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    public double getActualValue() {
        return actualValue;
    }

    public void setActualValue(double actualValue) {
        this.actualValue = actualValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
