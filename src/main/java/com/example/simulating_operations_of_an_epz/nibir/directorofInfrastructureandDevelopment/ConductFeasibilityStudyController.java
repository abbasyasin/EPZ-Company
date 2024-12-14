package com.example.simulating_operations_of_an_epz.nibir.directorofInfrastructureandDevelopment;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ConductFeasibilityStudyController
{
    @javafx.fxml.FXML
    private TextField projectscopeTextFileld;
    @javafx.fxml.FXML
    private TableColumn <FeasibilityStudy, String>TableBudgetColam;
    @javafx.fxml.FXML
    private TableColumn<FeasibilityStudy, String> projecscopeTableColam;
    @javafx.fxml.FXML
    private TableView <FeasibilityStudy>DataTableView;
    @javafx.fxml.FXML
    private TableColumn<FeasibilityStudy, String> timelineColm;
    @javafx.fxml.FXML
    private TextField BudgetTexTfield;
    @javafx.fxml.FXML
    private TextField TimelineTextField;

    private  ObservableList<FeasibilityStudy> feasibilityStudies = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        projecscopeTableColam.setCellValueFactory(new PropertyValueFactory<>("projectScope"));
        timelineColm.setCellValueFactory(new PropertyValueFactory<>("timeline"));
        TableBudgetColam.setCellValueFactory(new PropertyValueFactory<>("budget"));
        DataTableView.setItems(feasibilityStudies);
    }

    @javafx.fxml.FXML
    public void SaveFeasibilityButtonOnClick(ActionEvent actionEvent) {
        String projectScope = projectscopeTextFileld.getText();
        String timeline = TimelineTextField.getText();
        String budget = BudgetTexTfield.getText();
        FeasibilityStudy study = new FeasibilityStudy(projectScope, timeline, budget);
        feasibilityStudies.add(study);

        projectscopeTextFileld.clear();
        TimelineTextField.clear();
        BudgetTexTfield.clear();

        showAlert("Success", "Feasibility study saved successfully.");
    }

    @javafx.fxml.FXML
    public void notifyStakeHoldersButtonOnClick(ActionEvent actionEvent) {
        showAlert("Info", "Stakeholders notified about the feasibility study.");
    }

    @javafx.fxml.FXML
    public void BackButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/diFdDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}