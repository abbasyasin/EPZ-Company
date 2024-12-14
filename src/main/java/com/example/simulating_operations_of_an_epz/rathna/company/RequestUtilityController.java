package com.example.simulating_operations_of_an_epz.rathna.company;

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

public class RequestUtilityController
{
    @javafx.fxml.FXML
    private TableColumn<UtilityRequest, String> proposalNameTableCol;
    @javafx.fxml.FXML
    private TableColumn<UtilityRequest, String> utilityTypeTableCol1;
    @javafx.fxml.FXML
    private ComboBox<String> utilityTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<UtilityRequest, String> requiredAmountTableCol;
    @javafx.fxml.FXML
    private TableColumn<UtilityRequest, LocalDate> starDateTableCol;
    @javafx.fxml.FXML
    private DatePicker serviceStartDateDPicker;
    @javafx.fxml.FXML
    private TableView<UtilityRequest>  utilityServiceTableView;
    @javafx.fxml.FXML
    private TextField proposalNameTextField;

    private ObservableList<UtilityRequest> utilityRequests = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TextField requiredAmountTextField;
    ;

    @javafx.fxml.FXML
    public void initialize() {
        utilityTypeComboBox.setItems(FXCollections.observableArrayList("Electricity", "Water", "Gas", "Internet"));
        proposalNameTableCol.setCellValueFactory(new PropertyValueFactory<>("proposalName"));
        utilityTypeTableCol1.setCellValueFactory(new PropertyValueFactory<>("utilityType"));
        requiredAmountTableCol.setCellValueFactory(new PropertyValueFactory<>("requiredAmount"));
        starDateTableCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        utilityServiceTableView.setItems(utilityRequests);
    }

    @javafx.fxml.FXML
    public void backTableViewButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/company/companyDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void submitRequestButtonOnClick(ActionEvent actionEvent) {
        showAlert("Success", "Request submitted successfully!", Alert.AlertType.INFORMATION);
    }



    @javafx.fxml.FXML
    public void loadTableViewButtonOnClick(ActionEvent actionEvent) {
        String proposalName = proposalNameTextField.getText();
        String utilityType = utilityTypeComboBox.getValue();
        String requiredAmount = requiredAmountTextField.getText();
        LocalDate startDate = serviceStartDateDPicker.getValue();

        if (proposalName.isEmpty() || utilityType == null || requiredAmount.isEmpty() || startDate == null) {
            showAlert("Error", "Please fill in all the fields before submitting.", Alert.AlertType.ERROR);
            return;
        }
        UtilityRequest newRequest = new UtilityRequest(proposalName, utilityType, requiredAmount, startDate);
        utilityRequests.add(newRequest);
        proposalNameTextField.clear();
        requiredAmountTextField.clear();
        utilityTypeComboBox.getSelectionModel().clearSelection();
        serviceStartDateDPicker.setValue(null);
        utilityServiceTableView.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}