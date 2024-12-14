package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CreateEmergencyPlanController
{
    @javafx.fxml.FXML
    private TextField emergencycontactsTexTField;
    @javafx.fxml.FXML
    private TextField responsestepsTeXtField;
    @javafx.fxml.FXML
    private TableView DatatableView;
    @javafx.fxml.FXML
    private TableColumn<EmergencyPlan, String> EmergencycontactsTableColm;
    @javafx.fxml.FXML
    private TableColumn <EmergencyPlan, String>ResponsestepsTableColm;

    private final ObservableList<EmergencyPlan> planData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        EmergencycontactsTableColm.setCellValueFactory(new PropertyValueFactory<>("emergencyContacts"));
        ResponsestepsTableColm.setCellValueFactory(new PropertyValueFactory<>("responseSteps"));
        DatatableView.setItems(planData);
    }


    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/Nibir/environmentalandSafetyOfficer/eNsOfficerDasboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void submitPlanButtonOnClick(ActionEvent actionEvent) {
        String emergencyContacts = emergencycontactsTexTField.getText();
        String responseSteps = responsestepsTeXtField.getText();
        EmergencyPlan plan = new EmergencyPlan(emergencyContacts, responseSteps);

        planData.add(plan);
        showAlert("Success", "Emergency plan submitted successfully.");


    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}