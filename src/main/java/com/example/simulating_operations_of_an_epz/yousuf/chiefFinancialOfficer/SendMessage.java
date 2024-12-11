package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import java.io.Serializable;

public class SendMessage implements Serializable {
    private int employeeId;
    private String typeMessage;
    private String emailAddress;

    public SendMessage(int employeeId, String typeMessage, String emailAddress) {
        this.employeeId = employeeId;
        this.typeMessage = typeMessage;
        this.emailAddress = emailAddress;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
