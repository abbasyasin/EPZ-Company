package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import java.io.Serializable;

public class VisionStatement implements Serializable {
    private String statement;
    private int targetYear;

    public VisionStatement(String statement, int targetYear) {
        this.statement = statement;
        this.targetYear = targetYear;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public int getTargetYear() {
        return targetYear;
    }

    public void setTargetYear(int targetYear) {
        this.targetYear = targetYear;
    }
}
