package com.example.simulating_operations_of_an_epz.nibir.directorofInfrastructureandDevelopment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class diFdDashboardController {

    @FXML
    public void initialize() {
    }

    @FXML
    public void ScheduleStakeholderMeetingButtomOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/scheduleStakeholderMeeting.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Schedule Stakeholder Meeting");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void ConductFeasibilityStudyButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/conductFeasibilityStudy.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Conduct Feasibility Study");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void ProposeFutureProjectsButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/proposeFutureProjects.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Propose Future Projects");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void MonitorInfrastructureProjectsButtonOnclick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/monitorInfrastructureProjects.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Monitor Infrastructure Projects");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void AnnualMaintenancePlanButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/annualMaintenancePlan.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Annual Maintenance Plan");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void GenerateMonthlyReportButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/generateMonthlyReport.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Generate Monthly Report");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void planNewInfrastructureProjectButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/planNewInfrastructureProject.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Plan New Infrastructure Project");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void SubmitInfrastructureProposalButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/submitInfrastructureProposal.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Submit Infrastructure Proposal");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void logoutButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/login/LoginScene.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Login");
        window.setScene(scene);
        window.show();
    }
}
