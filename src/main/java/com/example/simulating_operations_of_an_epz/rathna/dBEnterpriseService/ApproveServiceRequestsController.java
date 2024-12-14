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

public class ApproveServiceRequestsController
{
    @javafx.fxml.FXML
    private TableColumn requestDateTableCol;
    @javafx.fxml.FXML
    private TableColumn requestIdTableCol;
    @javafx.fxml.FXML
    private TableColumn requestDetailsTableCol;
    @javafx.fxml.FXML
    private RadioButton rejectedRadioButton;
    @javafx.fxml.FXML
    private RadioButton approveRadioButton;
    @javafx.fxml.FXML
    private ToggleGroup directiorDicition;
    @javafx.fxml.FXML
    private TableView approveServiceRequestTableView;
    @javafx.fxml.FXML
    private TableColumn serviceTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn companynameTableCol;
    @javafx.fxml.FXML
    private ComboBox serviceTypeComboBox;
    @javafx.fxml.FXML
    private TextField companyNameTextField;
    @javafx.fxml.FXML
    private TextField requestDetailsTextField;
    @javafx.fxml.FXML
    private DatePicker requestDateDPicker;
    @javafx.fxml.FXML
    private TextField requestIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void SubmitButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTableViewButtionOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtionOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/dBEnterpriseService/dobedashbordController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("");
        window.setScene(scene2);
        window.show();
    }
}