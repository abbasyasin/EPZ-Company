package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import java.io.Serializable;

public class AssetProtection implements Serializable {
    private int assetId;
    private String assetType;
    private String location;
    private String secureStatus;

    public AssetProtection(int assetId, String assetType, String location, String secureStatus) {
        this.assetId = assetId;
        this.assetType = assetType;
        this.location = location;
        this.secureStatus = secureStatus;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSecureStatus() {
        return secureStatus;
    }

    public void setSecureStatus(String secureStatus) {
        this.secureStatus = secureStatus;
    }
}
