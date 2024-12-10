package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Objects;

public class Goal5bMonitorepzoperationalmetricsController
{
    @javafx.fxml.FXML
    private NumberAxis yAxis;
    @javafx.fxml.FXML
    private CategoryAxis xAxis;
    @javafx.fxml.FXML
    private TableView<OperationalMetrics> metricsTable;
    @javafx.fxml.FXML
    private LineChart<String,Number> metricChart;
    @javafx.fxml.FXML
    private TableColumn<OperationalMetrics,String> metricNameCol;
    @javafx.fxml.FXML
    private TableColumn<OperationalMetrics,LocalDate> edDateCol;
    @javafx.fxml.FXML
    private TableColumn<OperationalMetrics,LocalDate> strtDateCol;
    @javafx.fxml.FXML
    private TableColumn<OperationalMetrics,String> metricTypeCol;
    @javafx.fxml.FXML
    private TableColumn<OperationalMetrics,Double> MetricValueCol;
    XYChart.Series<String,Number> series;
    ObservableList<OperationalMetrics> operationalMetrics;

    @javafx.fxml.FXML
    public void initialize() {
        metricNameCol.setCellValueFactory(new PropertyValueFactory<>("metricName"));
        metricTypeCol.setCellValueFactory(new PropertyValueFactory<>("metricType"));
        MetricValueCol.setCellValueFactory(new PropertyValueFactory<>("metricValue"));
        strtDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        edDateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        xAxis.setLabel("Date");
        yAxis.setLabel("Value");
        series = new XYChart.Series<>();
        series.setName("Metrics");
        metricChart.getData().add(series);
        operationalMetrics= FXCollections.observableArrayList();
        loadmetrics();
    }

    @javafx.fxml.FXML
    public void generateAllReportOnActionButton(ActionEvent actionEvent) {
        StringBuilder report = new StringBuilder("Operational Metrics Report\n\n");
        for(OperationalMetrics metric: operationalMetrics) {
            report.append(metric.getMetricType()).append(" - ").append(metric.getMetricName()).append(": ").append(metric.getMetricValue()).append(" (").append(metric.getStartDate()).append(" - ").append(metric.getEndDate()).append(")\n");
        }
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operational Metrics Report");
        alert.setHeaderText("Operational Metrics Report");
        alert.setContentText(report.toString());
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal5_monitorepzoperationalmetrics.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }
    private void loadmetrics(){
        ObjectInputStream ois = null;
        try {
            OperationalMetrics o;
            ois = new ObjectInputStream(new FileInputStream("metrics.bin"));
            while (true){
                o= (OperationalMetrics) ois.readObject();
                metricsTable.getItems().add(o);
                operationalMetrics.add(o);
                chartvalues(o);
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

    private void chartvalues(OperationalMetrics o){
        series.getData().add(new XYChart.Data<>(o.getStartDate().toString(),o.getMetricValue()));
        metricChart.getData().remove(series);
        metricChart.getData().add(series);


    }
}