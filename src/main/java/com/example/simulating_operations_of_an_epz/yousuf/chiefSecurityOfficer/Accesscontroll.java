package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import java.io.Serializable;
import java.time.LocalDate;

public class Accesscontroll implements Serializable {
    private int userId;
    private String accessLavel;
    private String AreaName;
    private LocalDate date;

    public Accesscontroll(int userId, String accessLavel, String areaName, LocalDate date) {
        this.userId = userId;
        this.accessLavel = accessLavel;
        AreaName = areaName;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccessLavel() {
        return accessLavel;
    }

    public void setAccessLavel(String accessLavel) {
        this.accessLavel = accessLavel;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
