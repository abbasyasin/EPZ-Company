package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import java.io.Serializable;
import java.time.LocalDate;

public class Surveillance implements Serializable {
    private int cameraId;
    private String areaMonitor;
    private String liveStatus;
    private LocalDate date;

    public Surveillance(int cameraId, String areaMonitor, String liveStatus, LocalDate date) {
        this.cameraId = cameraId;
        this.areaMonitor = areaMonitor;
        this.liveStatus = liveStatus;
        this.date = date;
    }

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }

    public String getAreaMonitor() {
        return areaMonitor;
    }

    public void setAreaMonitor(String areaMonitor) {
        this.areaMonitor = areaMonitor;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
