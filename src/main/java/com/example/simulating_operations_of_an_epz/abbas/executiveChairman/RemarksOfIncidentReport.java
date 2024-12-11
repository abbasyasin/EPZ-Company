package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer.IncidentReport;

import java.io.Serializable;
import java.time.LocalDate;

public class RemarksOfIncidentReport extends IncidentReport implements Serializable {
    private String remarks;

    public RemarksOfIncidentReport(int incidentId, String incidentType, LocalDate date, String reportedBy, String remarks) {
        super(incidentId, incidentType, date, reportedBy);
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
