package com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;

import java.time.LocalDate;

public class Report {

    private String company;
    private String utility;
    private LocalDate startDate;
    private LocalDate endDate;
    private double usageData;


    public Report(String company, String utility, LocalDate startDate, LocalDate endDate, double usageData) {
        this.company = company;
        this.utility = utility;
        this.startDate = startDate;
        this.endDate = endDate;
        this.usageData = usageData;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
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

    public double getUsageData() {
        return usageData;
    }

    public void setUsageData(double usageData) {
        this.usageData = usageData;
    }

    @Override
    public String toString() {
        return "Report{" +
                "company='" + company + '\'' +
                ", utility='" + utility + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", usageData=" + usageData +
                '}';
    }
}

