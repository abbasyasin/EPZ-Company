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

public class RequestTrainingProgramController {

    @javafx.fxml.FXML
    private TextField topicTextField;

    @javafx.fxml.FXML
    private TextField employeeCountTextField;

    @javafx.fxml.FXML
    private DatePicker durationDatePicker;

    @javafx.fxml.FXML
    private TableColumn<TrainingProgramRequest, String> topicCol;

    @javafx.fxml.FXML
    private TableColumn<TrainingProgramRequest, Integer> employeeNumCol;

    @javafx.fxml.FXML
    private TableColumn<TrainingProgramRequest, LocalDate> startDateCol;

    @javafx.fxml.FXML
    private TableView<TrainingProgramRequest> trainingTableView;

    private ObservableList<TrainingProgramRequest> trainingRequests = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        topicCol.setCellValueFactory(new PropertyValueFactory<>("topic"));
        employeeNumCol.setCellValueFactory(new PropertyValueFactory<>("employeeCount"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        trainingTableView.setItems(trainingRequests);
    }

    @javafx.fxml.FXML
    public void submitButtonOnClick(ActionEvent actionEvent) {
        String topic = topicTextField.getText();
        String employeeCountStr = employeeCountTextField.getText();
        LocalDate startDate = durationDatePicker.getValue();

        if (topic.isEmpty() || employeeCountStr.isEmpty() || startDate == null || !employeeCountStr.matches("\\d+")) {
            showAlert("Error", "All fields are required and Employee Count must be a number.");
            return;
        }

        int employeeCount = Integer.parseInt(employeeCountStr);
        TrainingProgramRequest request = new TrainingProgramRequest(topic, employeeCount, startDate);
        trainingRequests.add(request);
        trainingTableView.getItems().add(request);

        showAlert("Success", "Training request submitted.");

        topicTextField.clear();
        employeeCountTextField.clear();
        durationDatePicker.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/company/companyDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }


}