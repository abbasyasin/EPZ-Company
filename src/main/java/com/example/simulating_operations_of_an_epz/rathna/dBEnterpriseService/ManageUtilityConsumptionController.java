package com.example.simulating_operations_of_an_epz.rathna.dBEnterpriseService;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ManageUtilityConsumptionController
{
    @javafx.fxml.FXML
    private TableColumn consumptionValueCol;
    @javafx.fxml.FXML
    private TableColumn dateCol;
    @javafx.fxml.FXML
    private TableView utilityConsumptionTableView;
    @javafx.fxml.FXML
    private TextField consumptionTextField;
    @javafx.fxml.FXML
    private TableColumn utilityTypeCol;
    @javafx.fxml.FXML
    private TextField updateUtilityTextField;
    @javafx.fxml.FXML
    private TableColumn companyTableCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveChangesButtonOnClick(ActionEvent actionEvent) {
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