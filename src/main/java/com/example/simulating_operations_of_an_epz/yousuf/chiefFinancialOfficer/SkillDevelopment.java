package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import java.io.Serializable;
import java.time.LocalDate;

public class SkillDevelopment implements Serializable {
    private String workshopTitle;
    private int employeeId;
    private LocalDate date;
    private String skill;

    public SkillDevelopment(String workshopTitle, int employeeId, LocalDate date, String skill) {
        this.workshopTitle = workshopTitle;
        this.employeeId = employeeId;
        this.date = date;
        this.skill = skill;
    }

    public String getWorkshopTitle() {
        return workshopTitle;
    }

    public void setWorkshopTitle(String workshopTitle) {
        this.workshopTitle = workshopTitle;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
