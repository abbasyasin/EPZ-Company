package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import java.io.Serializable;

public class SecurityStaff implements Serializable {
    private int staffId;
    private String staffName;
    private String role;
    private String time;

    public SecurityStaff(int staffId, String staffName, String role, String time) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.role = role;
        this.time = time;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
