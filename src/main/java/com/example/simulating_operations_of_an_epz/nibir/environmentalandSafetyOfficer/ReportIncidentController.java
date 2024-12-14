package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

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

public class ReportIncidentController {

    @javafx.fxml.FXML
    private TextField LocationTextField;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport, String> IncidenttypeTV;
    @javafx.fxml.FXML
    private TextField IncidenttypeTextField;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport, String> SeveritylevelTV;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport, LocalDate> DateTV;
    @javafx.fxml.FXML
    private DatePicker DatePIcker;
    @javafx.fxml.FXML
    private ComboBox<String> SeveritylevelComboBox;
    @javafx.fxml.FXML
    private TextField DescriptionTexTField;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport, String> DescriptionTV;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport, String> LocationTV;

    @javafx.fxml.FXML
    private TableView<IncidentReport> DataShowTableView;

    private ObservableList<IncidentReport> incidentReports = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        LocationTV.setCellValueFactory(new PropertyValueFactory<>("location"));
        IncidenttypeTV.setCellValueFactory(new PropertyValueFactory<>("incidentType"));
        SeveritylevelTV.setCellValueFactory(new PropertyValueFactory<>("severityLevel"));
        DateTV.setCellValueFactory(new PropertyValueFactory<>("date"));
        DescriptionTV.setCellValueFactory(new PropertyValueFactory<>("description"));


        DataShowTableView.setItems(incidentReports);

        SeveritylevelComboBox.setItems(FXCollections.observableArrayList("Low", "Medium", "High"));
    }

    @javafx.fxml.FXML
    public void SubmitIncidentReportButtonOnAction(ActionEvent actionEvent) {
        String location = LocationTextField.getText();
        String incidentType = IncidenttypeTextField.getText();
        String severityLevel = SeveritylevelComboBox.getValue();
        LocalDate date = DatePIcker.getValue();
        String description = DescriptionTexTField.getText();
        LocationTextField.clear();
        IncidenttypeTextField.clear();
        SeveritylevelComboBox.setValue(null);
        DatePIcker.setValue(null);

        DescriptionTexTField.clear();

        IncidentReport report = new IncidentReport(location, incidentType, severityLevel, date, description);
        incidentReports.add(report);


        showAlert("Success", "Incident report submitted successfully.");
    }

    @javafx.fxml.FXML
    public void BackButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/Nibir/environmentalandSafetyOfficer/eNsOfficerDasboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void DeleteButtonOnAction(ActionEvent actionEvent) {
        IncidentReport selectedReport = DataShowTableView.getSelectionModel().getSelectedItem();
        if (selectedReport != null) {
            incidentReports.remove(selectedReport);
            showAlert("Success", "Selected incident report deleted successfully.");
        } else {
            showAlert("Error", "No incident report selected for deletion.");
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
