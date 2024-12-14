package com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenerateReportController
{
    @javafx.fxml.FXML
    private TableColumn utilityCol;
    @javafx.fxml.FXML
    private TableColumn<Report, Double> usageDataCol;
    @javafx.fxml.FXML
    private TableView<Report> generateReportTableView;
    @javafx.fxml.FXML
    private TableColumn<Report, String> companyCol;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> utilityComboBox;
    @javafx.fxml.FXML
    private DatePicker sartDatePicker;
    @javafx.fxml.FXML
    private TextField companyTextField;
    @javafx.fxml.FXML
    private TextField usageDataTextField;
    @javafx.fxml.FXML
    private TableColumn<Report, LocalDate> endDateCol;
    @javafx.fxml.FXML
    private TableColumn<Report, LocalDate> startdateCol;

    private final List<Report> reportList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        companyCol.setCellValueFactory(new PropertyValueFactory<>("company"));
        utilityCol.setCellValueFactory(new PropertyValueFactory<>("utility"));
        startdateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        usageDataCol.setCellValueFactory(new PropertyValueFactory<>("usageData"));

        utilityComboBox.getItems().addAll("Electricity", "Water", "Gas");

        generateReportTableView.getItems().setAll(reportList);
    }

    @javafx.fxml.FXML
    public void submitReportButtonOnAction(ActionEvent actionEvent) {
        if (generateReportTableView.getItems().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "No Data", "No data available to create a report.");
            return;
        }
        showAlert(Alert.AlertType.INFORMATION, "Report Generated", "Report has been successfully created.");
    }


    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/dBEnterpriseService/dobedashbordController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void createReportForTableViewButtOnaction(ActionEvent actionEvent) {
        String company = companyTextField.getText();
        String utility = utilityComboBox.getValue();
        LocalDate startDate = sartDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        String usageDataText = usageDataTextField.getText();

        if (company.isEmpty() || utility == null || startDate == null || endDate == null || usageDataText.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill all fields correctly.");
            return;
        }

        double usageData;
        try {
            usageData = Double.parseDouble(usageDataText);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Usage data must be a valid number.");
            return;
        }

        Report newReport = new Report(company, utility, startDate, endDate, usageData);
        generateReportTableView.getItems().add(newReport);

        companyTextField.clear();
        utilityComboBox.getSelectionModel().clearSelection();
        sartDatePicker.setValue(null);
        endDatePicker.setValue(null);
        usageDataTextField.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}