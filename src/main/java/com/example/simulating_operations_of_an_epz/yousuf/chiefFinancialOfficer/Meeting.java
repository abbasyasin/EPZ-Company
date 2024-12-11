package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import java.io.Serializable;
import java.time.LocalDate;

public class Meeting implements Serializable {
    private int employeeId;
    private String meetingTitle;
    private LocalDate date;
    private int mobileNumber;

    public Meeting(int employeeId, String meetingTitle, LocalDate date, int mobileNumber) {
        this.employeeId = employeeId;
        this.meetingTitle = meetingTitle;
        this.date = date;
        this.mobileNumber = mobileNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}
