package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.OperationalMetrics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProfiteComparisionController {

    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private BarChart<String,Number> BudgetChart;
    XYChart.Series<String,Number> ProfitSeries;

    @FXML
    public void initialize() {
        xAxis.setLabel("Date");
        yAxis.setLabel("Value");
        ProfitSeries = new XYChart.Series<>();
        ProfitSeries.setName("Budget");
        BudgetChart.getData().add(ProfitSeries);
        BudgetChart.setVisible(false);


    }

    @FXML
    void backbutton(ActionEvent event) {

    }

    @FXML
    void showPiechart(ActionEvent event) {
        BudgetChart.setVisible(true);
        loadDepartmentBudget();

    }

    private void budgetChartValues(DepartmentBudget o){
        ProfitSeries.getData().add(new XYChart.Data<>(o.getDate().toString(),o.getAmount()));
        BudgetChart.getData().remove(ProfitSeries);
        BudgetChart.getData().add(ProfitSeries);


    }

    public void loadDepartmentBudget(){
        ObjectInputStream ois = null;
        try {
            DepartmentBudget y;
            ois = new ObjectInputStream(new FileInputStream("departmentBudget.bin"));
            while (true){
                y= (DepartmentBudget) ois.readObject();
                budgetChartValues(y);
            }
        }catch (Exception ex){
            try{
                if(ois != null){
                    ois.close();
                }
            }catch(IOException ex2){
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }


    }

}
