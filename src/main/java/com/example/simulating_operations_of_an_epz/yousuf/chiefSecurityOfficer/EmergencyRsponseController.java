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

public class EmergencyRsponseController {

    @FXML
    private ComboBox<?> contactNumbercombobox;

    @FXML
    private TableColumn<?, ?> contactnumberColumn;

    @FXML
    private ComboBox<?> emergencyCombobox;

    @FXML
    private TableColumn<?, ?> emergencyTypeColumn;

    @FXML
    private TableColumn<?, ?> planIdcolumn;

    @FXML
    private TextField planIdtextField;

    @FXML
    private TableColumn<?, ?> responseTeamColumn;

    @FXML
    private ComboBox<?> responseteamcombobox;

    @FXML
    private TableView<?> tableView;

    @FXML
    void addButton(ActionEvent event) {

    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/csODashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void emergencybutton(ActionEvent event) {

    }

    @FXML
    void showButton(ActionEvent event) {

    }

}
