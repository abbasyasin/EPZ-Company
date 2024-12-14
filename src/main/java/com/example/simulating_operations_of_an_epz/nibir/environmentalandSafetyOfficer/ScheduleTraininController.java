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
import java.time.LocalDate;
import java.util.Objects;

public class ScheduleTraininController
{
    @javafx.fxml.FXML
    private TextField targetAudiencetextFile;
    @javafx.fxml.FXML
    private TextField TopicTextField;
    @javafx.fxml.FXML
    private DatePicker DP;
    @javafx.fxml.FXML
    private TableView <TrainingSchedule>DataTableView;
    @javafx.fxml.FXML
    private TableColumn<TrainingSchedule, String> TopictableColam;
    @javafx.fxml.FXML
    private TableColumn <TrainingSchedule, String>targetAudienceTableColam;
    @javafx.fxml.FXML
    private TableColumn <TrainingSchedule, LocalDate>DateTableColam;

    private ObservableList<TrainingSchedule> trainingSchedules = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        TopictableColam.setCellValueFactory(new PropertyValueFactory<>("topic"));
        targetAudienceTableColam.setCellValueFactory(new PropertyValueFactory<>("targetAudience"));
        DateTableColam.setCellValueFactory(new PropertyValueFactory<>("date"));
        DataTableView.setItems(trainingSchedules);

    }

    @javafx.fxml.FXML
    public void ConfirmTraingButtonOnclick(ActionEvent actionEvent) {
        String topic = TopicTextField.getText();
        String targetAudience = targetAudiencetextFile.getText();
        LocalDate date = DP.getValue();
        TrainingSchedule schedule = new TrainingSchedule(topic, targetAudience, date);
        trainingSchedules.add(schedule);
        TopicTextField.clear();
        targetAudiencetextFile.clear();
        DP.setValue(null);
        showAlert("Success", "Training schedule confirmed successfully.");


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

    @javafx.fxml.FXML
    public void DeleteButtonOnclick(ActionEvent actionEvent) {
        TrainingSchedule selectedSchedule = DataTableView.getSelectionModel().getSelectedItem();
        if (selectedSchedule != null) {
            trainingSchedules.remove(selectedSchedule);
            showAlert("Success", "Selected training schedule deleted successfully.");
        } else {
            showAlert("Error", "No training schedule selected for deletion.");
        }

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}