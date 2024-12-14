package com.example.simulating_operations_of_an_epz.nibir.directorofInfrastructureandDevelopment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class AnnualMaintenancePlancontroller {

    @javafx.fxml.FXML
    private DatePicker DatePiker;
    @javafx.fxml.FXML
    private TableView<AnnualMaintenancePlan> DataTableVIew;
    @javafx.fxml.FXML
    private TableColumn<AnnualMaintenancePlan, LocalDate> DateTablecolm;
    @javafx.fxml.FXML
    private TableColumn<AnnualMaintenancePlan, String> MantenantenanceTableColam;
    @javafx.fxml.FXML
    private TableColumn<AnnualMaintenancePlan, String> assignedteamTableColam;
    @javafx.fxml.FXML
    private TextField MantenantenanceTextField;
    @javafx.fxml.FXML
    private ComboBox<String> AssignedteamComboBox;

    private final ObservableList<AnnualMaintenancePlan> maintenancePlans = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        DateTablecolm.setCellValueFactory(new PropertyValueFactory<>("date"));
        MantenantenanceTableColam.setCellValueFactory(new PropertyValueFactory<>("maintenanceDetails"));
        assignedteamTableColam.setCellValueFactory(new PropertyValueFactory<>("assignedTeam"));
        DataTableVIew.setItems(maintenancePlans);
        AssignedteamComboBox.setItems(FXCollections.observableArrayList("Team A", "Team B", "Team C"));
    }

    @javafx.fxml.FXML
    public void ApprovePlanButtonOnClick(ActionEvent actionEvent) {
        LocalDate date = DatePiker.getValue();
        String maintenanceDetails = MantenantenanceTextField.getText();
        String assignedTeam = AssignedteamComboBox.getValue();

        if (date == null || maintenanceDetails == null || maintenanceDetails.isEmpty() || assignedTeam == null) {
            showAlert("Error", "All fields must be filled out.");
            return;
        }

        AnnualMaintenancePlan plan = new AnnualMaintenancePlan(date, maintenanceDetails, assignedTeam);
        maintenancePlans.add(plan);

        DatePiker.setValue(null);
        MantenantenanceTextField.clear();
        AssignedteamComboBox.setValue(null);
    }

    @javafx.fxml.FXML
    public void BackButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/Nibir/directorofInfrastructureandDevelopment/diFdDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
