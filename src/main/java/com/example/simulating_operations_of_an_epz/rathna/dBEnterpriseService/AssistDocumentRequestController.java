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

public class AssistDocumentRequestController
{
    @javafx.fxml.FXML
    private TableColumn<Document, String> companyNameTableCol;
    @javafx.fxml.FXML
    private TextField permitTextField;
    @javafx.fxml.FXML
    private ComboBox<String> companyNameComboBox;
    @javafx.fxml.FXML
    private TextField businessPlanTextField;
    @javafx.fxml.FXML
    private TableView<Document>  dovumenttableView;
    @javafx.fxml.FXML
    private TableColumn<Document, String> permitTableCol;
    @javafx.fxml.FXML
    private TableColumn<Document, String> businessPlanTableCol;

    private ObservableList<Document> documentList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {
        companyNameComboBox.setItems(FXCollections.observableArrayList("Company A", "Company B", "Company C"));
        companyNameTableCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        permitTableCol.setCellValueFactory(new PropertyValueFactory<>("permit"));
        businessPlanTableCol.setCellValueFactory(new PropertyValueFactory<>("businessPlan"));

        dovumenttableView.setItems(documentList);
    }

    @javafx.fxml.FXML
    public void showOnTableButtonOnClick(ActionEvent actionEvent) {
        String companyName = companyNameComboBox.getValue();
        String permit = permitTextField.getText();
        String businessPlan = businessPlanTextField.getText();

        if (companyName != null && !permit.isEmpty() && !businessPlan.isEmpty()) {
            Document newDocument = new Document(companyName, permit, businessPlan);
            documentList.add(newDocument);

            permitTextField.clear();
            businessPlanTextField.clear();
        }
    }

    @javafx.fxml.FXML
    public void backOnTableButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/dBEnterpriseService/dobedashbordController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void submitOnTableButtonOnClick(ActionEvent actionEvent) {
        if (documentList.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Submission Error", "No documents to submit.");
            return;
        }
        System.out.println("Submitting data:");
        for (Document doc : documentList) {
            System.out.println("Company: " + doc.getCompanyName() + ", Permit: " + doc.getPermit() + ", Business Plan: " + doc.getBusinessPlan());
        }
        documentList.clear();
        showAlert(Alert.AlertType.INFORMATION, "Submission Successful", "All documents submitted successfully.");
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}