package com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;

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

public class RequestUtilityServiceController
{
    @javafx.fxml.FXML
    private ComboBox<String> utilityComboBox;
    @javafx.fxml.FXML
    private TextField ServiceLocationTextLabel;
    @javafx.fxml.FXML
    private TextField contactInformationTextField;
    @javafx.fxml.FXML
    private TableColumn<UtilityServiceRequest, String> utilityTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn<UtilityServiceRequest, String> contactInformationTableCol;
    @javafx.fxml.FXML
    private TableView<UtilityServiceRequest> utilityRequestTableView;
    @javafx.fxml.FXML
    private DatePicker starDateDpicker;
    @javafx.fxml.FXML
    private TableColumn<UtilityServiceRequest, LocalDate> startDayeTableCol;
    @javafx.fxml.FXML
    private TableColumn<UtilityServiceRequest, String> serviceTableCol;

    private ObservableList<UtilityServiceRequest> utilityRequestList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        utilityComboBox.getItems().addAll("Water", "Electricity", "Internet", "Gas");
        utilityTypeTableCol.setCellValueFactory(new PropertyValueFactory<>("utilityType"));
        serviceTableCol.setCellValueFactory(new PropertyValueFactory<>("serviceLocation"));
        startDayeTableCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        contactInformationTableCol.setCellValueFactory(new PropertyValueFactory<>("contactInformation"));

    }

    @javafx.fxml.FXML
    public void submitButtonOnClick(ActionEvent actionEvent) {
        String utilityType = utilityComboBox.getValue();
        String serviceLocation = ServiceLocationTextLabel.getText();
        LocalDate startDate = starDateDpicker.getValue();
        String contactInformation = contactInformationTextField.getText();

        UtilityServiceRequest request = new UtilityServiceRequest(utilityType, serviceLocation, contactInformation, startDate);
        utilityRequestList.add(request);
        utilityRequestTableView.getItems().add(request);

        showAlert(Alert.AlertType.INFORMATION, "Request Submitted", "Submission Successful", "Your utility service request has been submitted.");

        utilityComboBox.setValue(null);
        ServiceLocationTextLabel.clear();
        starDateDpicker.setValue(null);
        contactInformationTextField.clear();
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


    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}