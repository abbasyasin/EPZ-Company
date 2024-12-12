package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import java.io.Serializable;

public class Surveillance implements Serializable {
    private int cameraId;
    private String areaMonitor;
    private String liveStatus;

    public Surveillance(int cameraId, String areaMonitor, String liveStatus) {
        this.cameraId = cameraId;
        this.areaMonitor = areaMonitor;
        this.liveStatus = liveStatus;
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
}
