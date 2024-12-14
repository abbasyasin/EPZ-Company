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

public class ConductSafetyInspectionController
{
    @javafx.fxml.FXML
    private TextField violationsTextField;
    @javafx.fxml.FXML
    private TextField inspectiondateTextField;
    @javafx.fxml.FXML
    private TextField companynametextField;
    @javafx.fxml.FXML
    private TableColumn<SafetyInspection, String>InspectiondatetableColam;
    @javafx.fxml.FXML
    private TableView<SafetyInspection>DataTableView;
    @javafx.fxml.FXML
    private TableColumn<SafetyInspection, String>  CompanynameTableColam;
    @javafx.fxml.FXML
    private TableColumn <SafetyInspection, String>ViolationsTableColm;

    private final ObservableList<SafetyInspection> inspectionData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        CompanynameTableColam.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        InspectiondatetableColam.setCellValueFactory(new PropertyValueFactory<>("inspectionDate"));
        ViolationsTableColm.setCellValueFactory(new PropertyValueFactory<>("violations"));

        DataTableView.setItems(inspectionData);


    }

    @javafx.fxml.FXML
    public void saveInspectionReportButtonOnClick(ActionEvent actionEvent) {
        String companyName = companynametextField.getText();
        String inspectionDate = inspectiondateTextField.getText();
        String violations = violationsTextField.getText();

        SafetyInspection inspection = new SafetyInspection(companyName, inspectionDate, violations);
        inspectionData.add(inspection);
        companynametextField.clear();
        inspectiondateTextField.clear();
        violationsTextField.clear();
        showAlert("Success", "Inspection report saved successfully.");
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/Nibir/environmentalandSafetyOfficer/eNsOfficerDasboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
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