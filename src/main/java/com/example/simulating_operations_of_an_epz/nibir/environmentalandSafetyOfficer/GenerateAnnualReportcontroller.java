package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GenerateAnnualReportcontroller {
    @javafx.fxml.FXML
    private TableColumn<AnnualReportEntry, String> IncidentsTableColm;
    @javafx.fxml.FXML
    private TableView<AnnualReportEntry> DataViewTable;
    @javafx.fxml.FXML
    private TableColumn<AnnualReportEntry, String> recommendationsTableColm;
    @javafx.fxml.FXML
    private TextField recommendationsTextField;
    @javafx.fxml.FXML
    private TextField safetyinspectionsTextfield;
    @javafx.fxml.FXML
    private TextField incidentsTextFileld;
    @javafx.fxml.FXML
    private TableColumn<AnnualReportEntry, String> SafetyinspectionsTableColumn;

    private final ObservableList<AnnualReportEntry> annualReportData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        IncidentsTableColm.setCellValueFactory(new PropertyValueFactory<>("incidents"));
        SafetyinspectionsTableColumn.setCellValueFactory(new PropertyValueFactory<>("safetyInspections"));
        recommendationsTableColm.setCellValueFactory(new PropertyValueFactory<>("recommendations"));
        DataViewTable.setItems(annualReportData);
    }

    @javafx.fxml.FXML
    public void submitReportButtonOnClick(ActionEvent actionEvent) {
        String incidents = incidentsTextFileld.getText();
        String safetyInspections = safetyinspectionsTextfield.getText();
        String recommendations = recommendationsTextField.getText();

        if (incidents.isEmpty() || safetyInspections.isEmpty() || recommendations.isEmpty()) {
            showAlert("Error", "All fields must be filled out.");
            return;
        }

        AnnualReportEntry entry = new AnnualReportEntry(incidents, safetyInspections, recommendations);
        annualReportData.add(entry);

        incidentsTextFileld.clear();
        safetyinspectionsTextfield.clear();
        recommendationsTextField.clear();

        showAlert("Success", "Annual report entry submitted successfully.");
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/Nibir/environmentalandSafetyOfficer/eNsOfficerDasboardcontroller.fxml")));
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

    @javafx.fxml.FXML
    public void DeleleButtonOnClick(ActionEvent actionEvent) {
    }
}
