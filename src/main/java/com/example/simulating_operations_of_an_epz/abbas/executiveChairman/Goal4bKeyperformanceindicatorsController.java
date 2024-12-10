package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Objects;

public class Goal4bKeyperformanceindicatorsController
{
    @javafx.fxml.FXML
    private TableColumn<KPI, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<KPI,Double> actualValueCol;
    @javafx.fxml.FXML
    private TableColumn<KPI,String> kpiNameCol;
    @javafx.fxml.FXML
    private TableView<KPI> kpiTable;
    @javafx.fxml.FXML
    private TableColumn<KPI,Double> targetValueCol;
    @javafx.fxml.FXML
    private TableColumn<KPI,String> descriptionCol;
    @javafx.fxml.FXML
    private BarChart<String,Number> kpiChart;
    @javafx.fxml.FXML
    private NumberAxis yAxis;
    @javafx.fxml.FXML
    private CategoryAxis xAxis;
    private XYChart.Series<String,Number> target;
    private XYChart.Series<String,Number> actual;

    @javafx.fxml.FXML
    public void initialize() {
        kpiNameCol.setCellValueFactory(new PropertyValueFactory<>("kpiName"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        targetValueCol.setCellValueFactory(new PropertyValueFactory<>("targetValue"));
        actualValueCol.setCellValueFactory(new PropertyValueFactory<>("actualValue"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        xAxis.setLabel("Date");
        yAxis.setLabel("Value");
        target = new XYChart.Series<>();
        target.setName("target Value");
        actual = new XYChart.Series<>();
        actual.setName("actual Value");
        kpiChart.getData().add(target);
        kpiChart.getData().add(actual);

        loadKPI();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal4_keyperformanceindicators.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    private void loadKPI(){
        ObjectInputStream ois = null;
        try {
            KPI k;
            ois = new ObjectInputStream(new FileInputStream("kpirecords.bin"));
            while (true){
                k= (KPI) ois.readObject();
                kpiTable.getItems().add(k);
                chartvalues(k);
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

    private void chartvalues(KPI kpi){
        target.getData().add(new XYChart.Data<>(kpi.getDate().toString(),kpi.getTargetValue()));
        actual.getData().add(new XYChart.Data<>(kpi.getDate().toString(),kpi.getActualValue()));
        kpiChart.getData().remove(target);
        kpiChart.getData().remove(actual);
        kpiChart.getData().add(target);
        kpiChart.getData().add(actual);


    }
}