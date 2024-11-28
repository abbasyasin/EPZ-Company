package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Objects;

public class DepeartmentalBudgetController {

    @FXML
    private TextField amounttextArea;

    @FXML
    private TableColumn<?, ?> budgetColumn;

    @FXML
    private TableColumn<?, ?> depaermentcolumn;

    @FXML
    private ComboBox<?> departmentcombobox;

    @FXML
    private TableView<?> tableview;


    @FXML
    void backButtonDbA(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Departmental Budget");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    public void createBudgetForDepartmentButton(ActionEvent actionEvent) {
    }

    @FXML
    public void addButton(ActionEvent actionEvent) {
    }
}
