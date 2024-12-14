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

public class MonitorInfrastructureProjectsController {

    @javafx.fxml.FXML
    private DatePicker updateDateDP;
    @javafx.fxml.FXML
    private TableColumn<InfrastructureProject, LocalDate> updateDateTableColam;
    @javafx.fxml.FXML
    private TableColumn<InfrastructureProject, String> projectNameTableColm;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TableView<InfrastructureProject> DatatableView;
    @javafx.fxml.FXML
    private TextField projectIDTextFiield;
    @javafx.fxml.FXML
    private TextField projectNametextField;
    @javafx.fxml.FXML
    private TableColumn<InfrastructureProject, String> projectIDTableColm;
    @javafx.fxml.FXML
    private TableColumn<InfrastructureProject, String> statustableColam;

    private final ObservableList<InfrastructureProject> infrastructureProjects = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        projectIDTableColm.setCellValueFactory(new PropertyValueFactory<>("projectID"));
        projectNameTableColm.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        statustableColam.setCellValueFactory(new PropertyValueFactory<>("status"));
        updateDateTableColam.setCellValueFactory(new PropertyValueFactory<>("updateDate"));
        DatatableView.setItems(infrastructureProjects);

        statusComboBox.setItems(FXCollections.observableArrayList("In Progress", "Completed", "On Hold"));
    }

    @javafx.fxml.FXML
    public void SubmitButtonOnAction(ActionEvent actionEvent) {
        String projectID = projectIDTextFiield.getText();
        String projectName = projectNametextField.getText();
        String status = statusComboBox.getValue();
        LocalDate updateDate = updateDateDP.getValue();

        if (projectID.isEmpty() || projectName.isEmpty() || status == null || updateDate == null) {
            showAlert("Error", "All fields must be filled out.");
            return;
        }

        InfrastructureProject project = new InfrastructureProject(projectID, projectName, status, updateDate);
        infrastructureProjects.add(project);

        projectIDTextFiield.clear();
        projectNametextField.clear();
        statusComboBox.setValue(null);
        updateDateDP.setValue(null);

        showAlert("Success", "Project submitted successfully.");
    }

    @javafx.fxml.FXML
    public void backButtonONClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/diFdDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void deleteButtonONClick(ActionEvent actionEvent) {
        InfrastructureProject selectedProject = DatatableView.getSelectionModel().getSelectedItem();
        if (selectedProject != null) {
            infrastructureProjects.remove(selectedProject);
            showAlert("Success", "Selected project deleted successfully.");
        } else {
            showAlert("Error", "No project selected for deletion.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
