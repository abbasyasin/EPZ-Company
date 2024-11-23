package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

import java.io.IOException;
import java.util.Objects;

public class YearlyBudgetAllocatedController {

    @FXML
    private TextField SalariesandBenefitsTextArea;
    @FXML
    private TextField CountingencyFindTextArea;
    @FXML
    private TextField MarketingandPromotionsTextArea;
    @FXML
    private TextField InfrastructureMaintenanceTextArea;
    @FXML
    private TextField NewDevelopmentProject;
    @FXML
    private TextField MiscellaneousExpensesTextArea;
    @FXML
    private TableColumn tableViewAmount;
    @FXML
    private TableView tableViewData;
    @FXML
    private TableColumn tableViewCategory;
    @FXML
    private TableColumn tableviewPercentageOfBudget;
    @FXML
    private TextField totalBudgetTextArea;
    @FXML
    private TextField mPpercentage;
    @FXML
    private TextField cFpercentage;
    @FXML
    private TextField sBpercentage;
    @FXML
    private TextField IfsMsinpercentage;
    @FXML
    private TextField MePercentage;
    @FXML
    private TextField NDpPercentage;
    @FXML
    private TextField totalPercentage;

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
}
