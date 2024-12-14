package com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ResourceAllocationController
{
    @javafx.fxml.FXML
    private TableColumn<ResourceAllocationModel, String> requestIdCol;
    @javafx.fxml.FXML
    private DatePicker submittionDateDPicker;
    @javafx.fxml.FXML
    private TextField companyNameTextField;
    @javafx.fxml.FXML
    private TableColumn<ResourceAllocationModel, String> resourceRequestCol;
    @javafx.fxml.FXML
    private ComboBox<String> priorityComboBox;
    @javafx.fxml.FXML
    private TextField resourseRequestTextField;
    @javafx.fxml.FXML
    private ToggleGroup dirrectorDecission;
    @javafx.fxml.FXML
    private TableColumn<ResourceAllocationModel, String> companyNameCol;
    @javafx.fxml.FXML
    private TableColumn<ResourceAllocationModel, Integer> quantityCol;
    @javafx.fxml.FXML
    private TableView<ResourceAllocationModel> resourceManagementTableView;
    @javafx.fxml.FXML
    private RadioButton dicissionApproveRadioButton;
    @javafx.fxml.FXML
    private TableColumn<ResourceAllocationModel, LocalDate> submissionDateCol;
    @javafx.fxml.FXML
    private RadioButton dicissionRejectedRadioButton;
    @javafx.fxml.FXML
    private TextField requestIdTextField;
    @javafx.fxml.FXML
    private TextField quantityTextField;

    private ObservableList<ResourceAllocationModel>  resourceList = FXCollections.observableArrayList();;

    @javafx.fxml.FXML
    public void initialize() {
        priorityComboBox.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));
        requestIdCol.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        companyNameCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        resourceRequestCol.setCellValueFactory(new PropertyValueFactory<>("resourceRequest"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        submissionDateCol.setCellValueFactory(new PropertyValueFactory<>("submissionDate"));

        resourceManagementTableView.setItems(resourceList);
    }

    @javafx.fxml.FXML
    public void submitDecissionButtonClick(ActionEvent actionEvent) {
        String requestId = requestIdTextField.getText();
        String companyName = companyNameTextField.getText();
        String resourceRequest = resourseRequestTextField.getText();
        int quantity;
        try {
            quantity = Integer.parseInt(quantityTextField.getText());
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Quantity must be a number.");
            return;
        }
        LocalDate submissionDate = submittionDateDPicker.getValue();
        String priority = priorityComboBox.getValue();
        String decision = dicissionApproveRadioButton.isSelected() ? "Approved" : dicissionRejectedRadioButton.isSelected() ? "Rejected" : "Pending";

        if (requestId.isEmpty() || companyName.isEmpty() || resourceRequest.isEmpty() || submissionDate == null || priority == null) {
            showAlert("Missing Fields", "Please fill all fields before submitting.");
            return;
        }

        // Create a new model and add it to the list
        ResourceAllocationModel newResource = new ResourceAllocationModel(requestId, companyName, resourceRequest, quantity, submissionDate, priority, decision);
        resourceList.add(newResource);
    }


    @javafx.fxml.FXML
    public void backButtonClick(ActionEvent actionEvent) {
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}