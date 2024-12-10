package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import java.io.Serializable;

public class YearlyBudget implements Serializable {
    private String category;
    private double percentage;
    private double amount;

    public YearlyBudget(String category, double percentage, double amount) {
        this.category = category;
        this.percentage = percentage;
        this.amount = amount;
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
}
