package com.example.simulating_operations_of_an_epz.rathna.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ApplyFinancialAssistanceController
{
    @javafx.fxml.FXML
    private TextField amountRequiredTextField;
    @javafx.fxml.FXML
    private TextField projectPurposeTextField;
    @javafx.fxml.FXML
    private TextArea howDetailsAllinTextArea;
    @javafx.fxml.FXML
    private TextField submitApplicationTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/company/companyDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @Deprecated
    public void fileButtonOnClick(ActionEvent actionEvent) {
    }
}