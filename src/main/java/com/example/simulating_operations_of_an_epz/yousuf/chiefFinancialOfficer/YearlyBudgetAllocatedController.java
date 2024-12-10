package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class YearlyBudgetAllocatedController {

    @FXML
    private TextField amountTextArea;

    @FXML
    private ComboBox<String> categoryCombobox;

    @FXML
    private TextField percentageOFTExtArea;

    @FXML
    private TableColumn<YearlyBudget,Double> tableViewAmount;

    @FXML
    private TableColumn<YearlyBudget,String> tableViewCategory;

    @FXML
    private TableView<YearlyBudget> tableViewData;

    @FXML
    private TableColumn<YearlyBudget,Double> tableviewPercentageOfBudget;


    public void initialize() {
        categoryCombobox.getItems().addAll("Salaries","Logistics","Utilities","Operation","Miscellaneous");
        tableViewCategory.setCellValueFactory(new PropertyValueFactory<YearlyBudget,String>("category"));
        tableViewAmount.setCellValueFactory(new PropertyValueFactory<YearlyBudget,Double>("amount"));
        tableviewPercentageOfBudget.setCellValueFactory(new PropertyValueFactory<YearlyBudget,Double>("percentage"));

    }


    @FXML
    void backButtonYearlyBudget(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    public void createBudgetButton(ActionEvent event) {
    }

    @FXML
    public void addBudgetBUtton(ActionEvent actionEvent) {
        String category=categoryCombobox.getValue();
        double percentage=Double.parseDouble(percentageOFTExtArea.getText());
        double ammount=Double.parseDouble(amountTextArea.getText());
        double estimatedAmount=getCalculatedAmmount(percentage,ammount);
        YearlyBudget y=new YearlyBudget(category,percentage,estimatedAmount);
        tableViewData.getItems().add(y);

    }

    public double getCalculatedAmmount(Double percentage,Double amount){
        double estimatedAmount=amount*(percentage/100);
        return estimatedAmount;

    }
}
