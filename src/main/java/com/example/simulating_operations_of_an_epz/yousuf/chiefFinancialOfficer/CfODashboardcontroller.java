package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CfODashboardcontroller {

    @FXML
    void logoutCFO(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/login/LoginScene.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Login Page");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    public void yearlyBudgetAllocated(ActionEvent actionEvent) {
    }
}
