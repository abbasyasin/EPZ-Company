package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UpdatePolicyController {

    @FXML
    private DatePicker effectiveDatePicker;

    @FXML
    private TextField policyDescription;

    @FXML
    private TextField policyIdTExtfield;

    @FXML
    private TextField policytitleTextField;
    @FXML
    private TableColumn effectiveDateColumn;
    @FXML
    private TableColumn PolicyDescription;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn EmployeeIDColumn;
    @FXML
    private TableColumn policytitleColumn;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @FXML
    void addAndClear(ActionEvent event) {

    }

    @FXML
    public void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();}
}
