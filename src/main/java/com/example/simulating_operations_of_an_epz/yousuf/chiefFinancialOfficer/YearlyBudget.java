package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import java.io.Serializable;
import java.time.LocalDate;

public class YearlyBudget implements Serializable {
    private String category;
    private double percentage;
    private double amount;
    private LocalDate year;

    public YearlyBudget(String category, double percentage, double amount,LocalDate year) {
        this.category = category;
        this.percentage = percentage;
        this.amount = amount;
        this.year=year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }
}
