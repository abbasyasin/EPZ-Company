package com.example.simulating_operations_of_an_epz.rathna.company;

import java.io.Serializable;

public class ApplyPermitModel implements Serializable {
    private String companyInformation;
    private String permitType;
    private String proofOfOwnership;
    private String environmentalAssessment;
    private String projectDescription;

    public ApplyPermitModel(String companyInformation, String permitType, String proofOfOwnership, String environmentalAssessment, String projectDescription) {
        this.companyInformation = companyInformation;
        this.permitType = permitType;
        this.proofOfOwnership = proofOfOwnership;
        this.environmentalAssessment = environmentalAssessment;
        this.projectDescription = projectDescription;
    }

    public String getCompanyInformation() {
        return companyInformation;
    }

    public void setCompanyInformation(String companyInformation) {
        this.companyInformation = companyInformation;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public String getProofOfOwnership() {
        return proofOfOwnership;
    }

    public void setProofOfOwnership(String proofOfOwnership) {
        this.proofOfOwnership = proofOfOwnership;
    }

    public String getEnvironmentalAssessment() {
        return environmentalAssessment;
    }

    public void setEnvironmentalAssessment(String environmentalAssessment) {
        this.environmentalAssessment = environmentalAssessment;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

}
