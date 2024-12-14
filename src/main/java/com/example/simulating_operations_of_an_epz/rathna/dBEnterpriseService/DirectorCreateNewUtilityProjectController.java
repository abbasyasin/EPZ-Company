package com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DirectorCreateNewUtilityProjectController
{
    @javafx.fxml.FXML
    private DatePicker startDateDPicker;
    @javafx.fxml.FXML
    private ComboBox resourceStaffComboBox;
    @javafx.fxml.FXML
    private ComboBox resouceEquipmentComboBox;
    @javafx.fxml.FXML
    private TextField projectNameTextfield;
    @javafx.fxml.FXML
    private TextField budgetTextfield;
    @javafx.fxml.FXML
    private TableView utilityTableView;
    @javafx.fxml.FXML
    private TableColumn equipmentTableCol;
    @javafx.fxml.FXML
    private TableColumn pojectNameTableCol;
    @javafx.fxml.FXML
    private TableColumn stuffTableCol;
    @javafx.fxml.FXML
    private TableColumn starDateTableCol;
    @javafx.fxml.FXML
    private TableColumn budgetTableCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveProjectButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/dBEnterpriseService/dobedashbordController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("");
        window.setScene(scene2);
        window.show();
    }
}