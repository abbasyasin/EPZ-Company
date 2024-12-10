package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AccessControllManagementController {

    @FXML
    private ComboBox<?> AccessLAbelCombobox;

    @FXML
    private TableColumn<?, ?> accesslavelColumn;

    @FXML
    private TableColumn<?, ?> areaNameColumn;

    @FXML
    private TextField areaNameTExtfield;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private DatePicker datepickeR;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> userIdColumn;

    @FXML
    private TextField userIdTextField;

    @FXML
    void applybutton(ActionEvent event) {

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
