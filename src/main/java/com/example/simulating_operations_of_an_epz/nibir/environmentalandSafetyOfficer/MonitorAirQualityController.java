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
import java.util.Objects;

public class MonitorAirQualityController
{
    @javafx.fxml.FXML
    private TableColumn<AirQualityEntry, String> PollutionlevelstableColam;
    @javafx.fxml.FXML
    private ComboBox<String> sendwarningComboBox;
    @javafx.fxml.FXML
    private TextField companynameTextField;
    @javafx.fxml.FXML
    private TableView<AirQualityEntry> DataShowTableView;
    @javafx.fxml.FXML
    private TextField pollutionLevelstextField;
    @javafx.fxml.FXML
    private ComboBox <String>issueFineComboBox;
    @javafx.fxml.FXML
    private TableColumn<AirQualityEntry, String>  IssuefineTableColam;
    @javafx.fxml.FXML
    private TableColumn<AirQualityEntry, String> CompanynameTableColam;
    @javafx.fxml.FXML
    private TableColumn<AirQualityEntry, String> sendwarningtableColam;

    private  ObservableList<AirQualityEntry> airQualityData = FXCollections.observableArrayList();
    private  ObservableList<String> warningOptions = FXCollections.observableArrayList("Yes", "No");
    private  ObservableList<String> fineOptions = FXCollections.observableArrayList("5000", "10000", "50000");


    @javafx.fxml.FXML
    public void initialize() {
        CompanynameTableColam.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        PollutionlevelstableColam.setCellValueFactory(new PropertyValueFactory<>("pollutionLevels"));
        sendwarningtableColam.setCellValueFactory(new PropertyValueFactory<>("sendWarning"));
        IssuefineTableColam.setCellValueFactory(new PropertyValueFactory<>("issueFine"));
        DataShowTableView.setItems(airQualityData);
        sendwarningComboBox.setItems(warningOptions);
        issueFineComboBox.setItems(fineOptions);

    }

    @javafx.fxml.FXML
    public void DeleteButtonOnClick(ActionEvent actionEvent) {
        AirQualityEntry selectedEntry = DataShowTableView.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            airQualityData.remove(selectedEntry);
            showAlert("Success", "Selected entry deleted successfully.");
        } else {
            showAlert("Error", "No entry selected for deletion.");
        }

    }


    @javafx.fxml.FXML
    public void saveComplianceStatusButtonOnClick(ActionEvent actionEvent) {
        String companyName = companynameTextField.getText();
        String pollutionLevels = pollutionLevelstextField.getText();
        String sendWarning = sendwarningComboBox.getValue();
        String issueFine = issueFineComboBox.getValue();
        AirQualityEntry entry = new AirQualityEntry(companyName, pollutionLevels, sendWarning, issueFine);
        airQualityData.add(entry);
        companynameTextField.clear();
        pollutionLevelstextField.clear();
        sendwarningComboBox.setValue(null);
        issueFineComboBox.setValue(null);

        showAlert("Success", "Compliance status saved successfully.");
    }

    @javafx.fxml.FXML
    public void BackButtonOnClick(ActionEvent actionEvent) throws IOException {
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