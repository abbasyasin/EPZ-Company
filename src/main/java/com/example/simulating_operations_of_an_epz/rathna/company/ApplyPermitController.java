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
import java.util.Objects;

public class ApplyPermitController
{
    @javafx.fxml.FXML
    private TableColumn<ApplyPermitModel, String> companyInformationTableCol;
    @javafx.fxml.FXML
    private TableView<ApplyPermitModel> permitTableView;
    @javafx.fxml.FXML
    private TextField companyInformationTextField;
    @javafx.fxml.FXML
    private TableColumn<ApplyPermitModel, String> permitTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn<ApplyPermitModel, String> proofOwnershipTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> permitTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<ApplyPermitModel, String> environmentalAssessmentsTableCol;
    @javafx.fxml.FXML
    private TableColumn<ApplyPermitModel, String> projectDescriptionTableCol;
    @javafx.fxml.FXML
    private TextField ProofofOwnershipTextField;
    @javafx.fxml.FXML
    private TextField enviromentalAssesMentTextField;
    @javafx.fxml.FXML
    private TextField projectDescriptionTextFiled;

    private final ObservableList<ApplyPermitModel> permitData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        permitTypeComboBox.setItems(FXCollections.observableArrayList("environmental assessments", "proof of ownership", "Other"));
        companyInformationTableCol.setCellValueFactory(new PropertyValueFactory<>("companyInformation"));
        permitTypeTableCol.setCellValueFactory(new PropertyValueFactory<>("permitType"));
        proofOwnershipTableCol.setCellValueFactory(new PropertyValueFactory<>("proofOfOwnership"));
        environmentalAssessmentsTableCol.setCellValueFactory(new PropertyValueFactory<>("environmentalAssessment"));
        projectDescriptionTableCol.setCellValueFactory(new PropertyValueFactory<>("projectDescription"));

        permitTableView.setItems(permitData);
    }

    @javafx.fxml.FXML
    public void loadButtonOnClick(ActionEvent actionEvent) {

        String companyInformation = companyInformationTextField.getText();
        String permitType = permitTypeComboBox.getSelectionModel().getSelectedItem();
        String proofOfOwnership = ProofofOwnershipTextField.getText();
        String environmentalAssessment = enviromentalAssesMentTextField.getText();
        String projectDescription = projectDescriptionTextFiled.getText();

        companyInformationTextField.clear();
        permitTypeComboBox.getSelectionModel().clearSelection();
        ProofofOwnershipTextField.clear();
        enviromentalAssesMentTextField.clear();
        projectDescriptionTextFiled.clear();

        if (companyInformation.isEmpty() || permitType == null || proofOfOwnership.isEmpty() ||
                environmentalAssessment.isEmpty() || projectDescription.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields.");
            alert.showAndWait();
            return;
        }
        loadButtonOnClick(actionEvent);
        ApplyPermitModel permit = new ApplyPermitModel(companyInformation, permitType, proofOfOwnership, environmentalAssessment, projectDescription);
        permitData.add(permit);

    }

    @javafx.fxml.FXML
    public void submitButtonOnClick(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Permit application submitted successfully.");
        alert.showAndWait();

    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/company/companyDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("");
        window.setScene(scene2);
        window.show();
    }


}