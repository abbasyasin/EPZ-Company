package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer.YearlyBudget;

import java.time.LocalDate;

public class RemarksOfYearlyReport extends YearlyBudget {
    private String remarks;

    public RemarksOfYearlyReport(String category, double percentage, double amount, LocalDate year, String remarks) {
        super(category, percentage, amount, year);
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
