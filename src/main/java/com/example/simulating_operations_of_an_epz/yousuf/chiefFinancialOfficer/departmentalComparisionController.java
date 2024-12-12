package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

public class departmentalComparisionController
{
    @javafx.fxml.FXML
    private NumberAxis yAxis;
    @javafx.fxml.FXML
    private CategoryAxis xAxis;
    XYChart.Series<String,Number> ProfitSeries;
    @javafx.fxml.FXML
    private BarChart<String,Number> BudgetbarChart;
    @javafx.fxml.FXML
    public void initialize() {
        xAxis.setLabel("Date");
        yAxis.setLabel("Value");
        ProfitSeries=new XYChart.Series<>();
        ProfitSeries.setName("Budget");
        BudgetbarChart.getData().add(ProfitSeries);
        BudgetbarChart.setVisible(false);

    }

    @javafx.fxml.FXML
    public void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();}

    @javafx.fxml.FXML
    public void showBarchart(ActionEvent actionEvent) {
        BudgetbarChart.setVisible(true);
        loadDepartmentBudget();
    }
    private void budgetChartValues(DepartmentBudget o){
        ProfitSeries.getData().add(new XYChart.Data<>(o.getDate().toString(),o.getAmount()));
        BudgetbarChart.getData().remove(ProfitSeries);
        BudgetbarChart.getData().add(ProfitSeries);}
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