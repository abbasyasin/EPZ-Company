package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import java.io.Serializable;
import java.time.LocalDate;

public class DepartmentBudget implements Serializable {
    private String department;
    private double amount;
    private LocalDate date;

    public DepartmentBudget(String department, double amount, LocalDate date) {
        this.department = department;
        this.amount = amount;
        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
