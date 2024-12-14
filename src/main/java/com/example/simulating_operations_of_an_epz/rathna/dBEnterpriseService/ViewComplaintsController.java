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
import java.util.Objects;

public class ViewComplaintsController
{

    @javafx.fxml.FXML
    private ComboBox<String> teamMemberComboBox;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> companyNameCol;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> complaintIDCol;
    @javafx.fxml.FXML
    private ComboBox<String> resolutionStatusComboBox;
    @javafx.fxml.FXML
    private TableView<Complaint> complaintsTableView;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> issueDescriptionCol;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> dateComplaintCol;
    @javafx.fxml.FXML
    private TextField companyNameTextField;
    @javafx.fxml.FXML
    private TextField complainIDTextField;
    @javafx.fxml.FXML
    private TextField issueDescriptionTextField;

    private final ObservableList<Complaint> complaints = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        resolutionStatusComboBox.setItems(FXCollections.observableArrayList("Resolved", "Unresolved", "Pending"));

        companyNameCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("resolutionStatus"));
        complaintIDCol.setCellValueFactory(new PropertyValueFactory<>("complaintID"));
        issueDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("issueDescription"));
        dateComplaintCol.setCellValueFactory(new PropertyValueFactory<>("dateOfComplaint"));

        complaintsTableView.setItems(complaints);

    }

    @javafx.fxml.FXML
    public void submitResolutionOnButtonClick(ActionEvent actionEvent) {
        String complaintID = complainIDTextField.getText();
        String resolutionStatus = resolutionStatusComboBox.getValue();

        if (complaintID.isEmpty() || resolutionStatus == null) {
            showAlert(Alert.AlertType.ERROR, "Submission Error", "Please fill in all required fields.");
            return;
        }

        Complaint selectedComplaint = complaints.stream()
                .filter(complaint -> complaint.getComplaintID().equals(complaintID))
                .findFirst()
                .orElse(null);

        if (selectedComplaint != null) {
            selectedComplaint.setResolutionStatus(resolutionStatus);
            complaintsTableView.refresh();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Resolution status updated successfully.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Complaint ID not found.");
        }
    }

    @javafx.fxml.FXML
    public void backOnButtonClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/dBEnterpriseService/dobedashbordController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("");
        window.setScene(scene2);
        window.show();
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}