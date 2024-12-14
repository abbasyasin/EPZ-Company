package com.example.simulating_operations_of_an_epz.rathna.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SubmitProfitLossController
{
    @javafx.fxml.FXML
    private TextField expencesTextField;
    @javafx.fxml.FXML
    private TextField reveneueTextFiel;
    @javafx.fxml.FXML
    private DatePicker financialDatePicker;
    @javafx.fxml.FXML
    private PieChart piechart;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void showChartButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/company/companyDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("");
        window.setScene(scene2);
        window.show();
    }
}