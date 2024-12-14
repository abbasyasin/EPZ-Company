package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class eNsOfficerDasboardcontroller {

    @javafx.fxml.FXML
    public void initialize() {
        // Initialization logic if needed
    }

    @javafx.fxml.FXML
    public void scheduleTrainingButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/environmentalandSafetyOfficer/scheduleTraining.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Schedule Training");
        window.setScene(scene);
        window.show();
    }

    @javafx.fxml.FXML
    public void generateAnnualReportButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/environmentalandSafetyOfficer/generateAnnualReport.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Generate Annual Report");
        window.setScene(scene);
        window.show();
    }

    @javafx.fxml.FXML
    public void conductSafetyInspectionButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/environmentalandSafetyOfficer/conductSafetyInspection.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Conduct Safety Inspection");
        window.setScene(scene);
        window.show();
    }

    @javafx.fxml.FXML
    public void monitorAirQualityButtonOnCilick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/environmentalandSafetyOfficer/monitorAirQuality.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Monitor Air Quality");
        window.setScene(scene);
        window.show();
    }



    @javafx.fxml.FXML
    public void logoutButtononClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/login/LoginScene.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Login");
        window.setScene(scene);
        window.show();
    }

    @javafx.fxml.FXML
    public void createEmergencyPlanButtononClick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/environmentalandSafetyOfficer/createEmergencyPlan.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Create Emergency Plan");
        window.setScene(scene);
        window.show();
    }

    @javafx.fxml.FXML
    public void conductImpactAssessmentButtonOncilick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/environmentalandSafetyOfficer/conductImpactAssessment.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Conduct Impact Assessment");
        window.setScene(scene);
        window.show();
    }

    @javafx.fxml.FXML
    public void monitorWasteManagementButtononCllick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/environmentalandSafetyOfficer/monitorWasteManagement.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Monitor Waste Management");
        window.setScene(scene);
        window.show();
    }

    @javafx.fxml.FXML
    public void reportIncidentButtonOnCilick(ActionEvent actionEvent) throws IOException {
        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/environmentalandSafetyOfficer/reportIncident.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("reportIncident");
        window.setScene(scene);
        window.show();
    }
}
