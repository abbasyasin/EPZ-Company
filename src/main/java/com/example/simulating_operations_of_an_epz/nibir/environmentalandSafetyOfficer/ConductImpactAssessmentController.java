package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

public class ConductImpactAssessmentController
{
    @javafx.fxml.FXML
    private TextField DescriptionTexTField;
    @javafx.fxml.FXML
    private TextField locationTextField;
    @javafx.fxml.FXML
    private TextField projectNameTextField;
    @javafx.fxml.FXML
    private TableColumn<ImpactAssessment,String> locationTableColm;
    @javafx.fxml.FXML
    private TableView<ImpactAssessment> DataTableView;
    @javafx.fxml.FXML
    private TableColumn<ImpactAssessment, String>ProjectnameTableColm;
    @javafx.fxml.FXML
    private TableColumn<ImpactAssessment, String>DescriptiontableColm;

    private final ObservableList<ImpactAssessment> assessmentData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        ProjectnameTableColm.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        locationTableColm.setCellValueFactory(new PropertyValueFactory<>("location"));
        DescriptiontableColm.setCellValueFactory(new PropertyValueFactory<>("description"));
    }


    @javafx.fxml.FXML
    public void submitAssessmentButtonOnClick(ActionEvent actionEvent) {
        String projectName = projectNameTextField.getText();
        String location = locationTextField.getText();
        String description = DescriptionTexTField.getText();
        ImpactAssessment assessment = new ImpactAssessment(projectName, location, description);
        assessmentData.add(assessment);
        projectNameTextField.clear();
        locationTextField.clear();
        DescriptionTexTField.clear();
        DataTableView.setItems(assessmentData);
        showAlert("Success", "Assessment submitted successfully.");

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(Event event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/Nibir/environmentalandSafetyOfficer/eNsOfficerDasboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }


}