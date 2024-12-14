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

public class SubmitFeedbackController
{
    @javafx.fxml.FXML
    private TextField issuesEncounterdTextField;
    @javafx.fxml.FXML
    private TextField serviceQualityTextField;
    @javafx.fxml.FXML
    private TableView<FeedbackModel> submitFeedBackTableView;
    @javafx.fxml.FXML
    private TableColumn<FeedbackModel, String> issuesEncountedTableCol;
    @javafx.fxml.FXML
    private TableColumn<FeedbackModel, String> serviceQualityTableCol;
    @javafx.fxml.FXML
    private DatePicker feedbackDateDPicker;
    @javafx.fxml.FXML
    private TableColumn<FeedbackModel, LocalDate> feedbackDateTableCol;

    private ObservableList<FeedbackModel> feedbackList = FXCollections.observableArrayList();    @javafx.fxml.FXML
    public void initialize() {
    issuesEncountedTableCol.setCellValueFactory(new PropertyValueFactory<>("issueEncountered"));
    serviceQualityTableCol.setCellValueFactory(new PropertyValueFactory<>("serviceQuality"));
    feedbackDateTableCol.setCellValueFactory(new PropertyValueFactory<>("feedbackDate"));

    submitFeedBackTableView.setItems(feedbackList);

    }

    @javafx.fxml.FXML
    public void submitButtonOnClick(ActionEvent actionEvent) {
        String issuesEncountered = issuesEncounterdTextField.getText();
        String serviceQuality = serviceQualityTextField.getText();
        LocalDate feedbackDate = feedbackDateDPicker.getValue();

        FeedbackModel feedback = new FeedbackModel(issuesEncountered, serviceQuality, feedbackDate);


        feedbackList.add(feedback);

        showAlert(Alert.AlertType.INFORMATION, "Request Submitted", "Submission Successful", "Your utility service request has been submitted.");


        issuesEncounterdTextField.clear();
        serviceQualityTextField.clear();
        feedbackDateDPicker.setValue(null);

        System.out.println("Feedback submitted: " + feedback);
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

    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}