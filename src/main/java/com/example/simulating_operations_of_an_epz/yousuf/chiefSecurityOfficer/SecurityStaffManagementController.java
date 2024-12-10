package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SecurityStaffManagementController {

    @FXML
    private TableColumn<?, ?> roleColumn;

    @FXML
    private ComboBox<?> rolecombobox;

    @FXML
    private TableColumn<?, ?> shifttimingColumn;

    @FXML
    private TextField shifttimingTextField;

    @FXML
    private TableColumn<?, ?> staffIdColumn;

    @FXML
    private TextField staffIdTExtfield;

    @FXML
    private TableColumn<?, ?> staffNameColumn;

    @FXML
    private TextField staffNameTextField;

    @FXML
    private TableView<?> tableview;

    @FXML
    void applyButton(ActionEvent event) {

    }

    @FXML
    void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/csODashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void showbutton(ActionEvent event) {

    }

}
