package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import java.io.Serializable;
import java.time.LocalDate;

public class Visitor implements Serializable {
    private String visitorName;
    private String visitOfPurpose;
    private LocalDate date;
    private String hostPerson;

    public Visitor(String visitorName, String visitOfPurpose, LocalDate date, String hostPerson) {
        this.visitorName = visitorName;
        this.visitOfPurpose = visitOfPurpose;
        this.date = date;
        this.hostPerson = hostPerson;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitOfPurpose() {
        return visitOfPurpose;
    }

    public void setVisitOfPurpose(String visitOfPurpose) {
        this.visitOfPurpose = visitOfPurpose;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHostPerson() {
        return hostPerson;
    }

    public void setHostPerson(String hostPerson) {
        this.hostPerson = hostPerson;
    }
}
