package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SurveillanceMonitoringController
{
    @FXML
    private ComboBox<?> areamonioredcombobox;

    @FXML
    private TextField cameraIdTextField;

    @FXML
    private ComboBox<?> livefieldStatusCombobox;

    @javafx.fxml.FXML

    public void initialize() {
    }

    @javafx.fxml.FXML
    public void reportedFileButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addButton(ActionEvent actionEvent) {
    }

    @FXML
    public void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/csODashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }
}