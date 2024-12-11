package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import java.io.Serializable;
import java.time.LocalDate;

public class Audit implements Serializable {
    private int auditId;
    private String auditType;
    private String auditDepartment;
    private LocalDate date;

    public Audit(int auditId, String auditType, String auditDepartment, LocalDate date) {
        this.auditId = auditId;
        this.auditType = auditType;
        this.auditDepartment = auditDepartment;
        this.date = date;
    }

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getAuditDepartment() {
        return auditDepartment;
    }

    public void setAuditDepartment(String auditDepartment) {
        this.auditDepartment = auditDepartment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
