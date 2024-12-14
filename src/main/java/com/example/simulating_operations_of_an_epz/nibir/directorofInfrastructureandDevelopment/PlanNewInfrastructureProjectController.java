package com.example.simulating_operations_of_an_epz.nibir.directorofInfrastructureandDevelopment;

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

public class PlanNewInfrastructureProjectController {

    @javafx.fxml.FXML
    private TableView<InfrastructureProjectPlan> projectTableview;
    @javafx.fxml.FXML
    private TextField budgetTextField;
    @javafx.fxml.FXML
    private TableColumn<InfrastructureProjectPlan, String> BudgetTC;
    @javafx.fxml.FXML
    private ComboBox<String> projectTypeCombobox;
    @javafx.fxml.FXML
    private TableColumn<InfrastructureProjectPlan, String> TimelineTC;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableColumn<InfrastructureProjectPlan, String> DescriptionTC;
    @javafx.fxml.FXML
    private TableColumn<InfrastructureProjectPlan, String> NameTC;
    @javafx.fxml.FXML
    private TextField descriptionTextField;
    @javafx.fxml.FXML
    private TextField timelineTextField;
    @javafx.fxml.FXML
    private TableColumn<InfrastructureProjectPlan, String> projectTypeTC;

    private ObservableList<InfrastructureProjectPlan> projectPlans = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        NameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        DescriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        projectTypeTC.setCellValueFactory(new PropertyValueFactory<>("projectType"));
        TimelineTC.setCellValueFactory(new PropertyValueFactory<>("timeline"));
        BudgetTC.setCellValueFactory(new PropertyValueFactory<>("budget"));


        projectTableview.setItems(projectPlans);


        projectTypeCombobox.setItems(FXCollections.observableArrayList("Industrial1", "Industrial2", "Industrial3", "Industrial4"));
    }

    @javafx.fxml.FXML
    public void notifyStakeholdersButtonOnClick(ActionEvent actionEvent) {
        showAlert("Info", "Stakeholders have been notified about the new project plan.");
    }

    @javafx.fxml.FXML
    public void BackButtonOnClick(ActionEvent actionEvent) throws IOException {

        Parent sceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/diFdDashboardController.fxml")));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene);
        window.show();
    }

    @javafx.fxml.FXML
    public void deleteButtonOnClick(ActionEvent actionEvent) {

        InfrastructureProjectPlan selectedPlan = projectTableview.getSelectionModel().getSelectedItem();
        if (selectedPlan != null) {
            projectPlans.remove(selectedPlan);
            showAlert("Success", "Selected project plan deleted successfully.");
        } else {
            showAlert("Error", "No project plan selected for deletion.");
        }
    }

    @javafx.fxml.FXML
    public void submitProjectButtonOnclick(ActionEvent actionEvent) {

        String name = nameTextField.getText();
        String description = descriptionTextField.getText();
        String projectType = projectTypeCombobox.getValue();
        String timeline = timelineTextField.getText();
        String budget = budgetTextField.getText();

        if (name.isEmpty() || description.isEmpty() || projectType == null || timeline.isEmpty() || budget.isEmpty()) {
            showAlert("Error", "All fields must be filled out.");
            return;
        }


        InfrastructureProjectPlan plan = new InfrastructureProjectPlan(name, description, projectType, timeline, budget);
        projectPlans.add(plan);


        nameTextField.clear();
        descriptionTextField.clear();
        projectTypeCombobox.setValue(null);
        timelineTextField.clear();
        budgetTextField.clear();


        showAlert("Success", "Project plan submitted successfully.");
    }

    private void showAlert(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
