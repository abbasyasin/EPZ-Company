package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Goal5MonitorepzoperationalmetricsController
{
    @javafx.fxml.FXML
    private TableColumn<OperationalMetrics, LocalDate> endDateCol;
    @javafx.fxml.FXML
    private TableView<OperationalMetrics> metricsTable;
    @javafx.fxml.FXML
    private DatePicker startDatePIcler;
    @javafx.fxml.FXML
    private TextField metricNamefield;
    @javafx.fxml.FXML
    private TableColumn<OperationalMetrics,Double> MetricsValueCol;
    @javafx.fxml.FXML
    private TextField metricValueField;
    @javafx.fxml.FXML
    private TableColumn<OperationalMetrics,String> metricsTypeCol;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn<OperationalMetrics,LocalDate> startDateCol;
    @javafx.fxml.FXML
    private ComboBox<String> metricTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<OperationalMetrics,String> metricsNameCol;
    ObservableList<OperationalMetrics> metricsList= FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {
        metricTypeComboBox.getItems().addAll("Revenue","Investment","projects");
        metricsNameCol.setCellValueFactory(new PropertyValueFactory<>("metricName"));
        metricsTypeCol.setCellValueFactory(new PropertyValueFactory<>("metricType"));
        MetricsValueCol.setCellValueFactory(new PropertyValueFactory<>("metricValue"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }

    @javafx.fxml.FXML
    public void loadAllMetricsOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal5b_monitorepzoperationalmetrics.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }


    @javafx.fxml.FXML
    public void addMetricOnActionButton(ActionEvent actionEvent) {
        String type=metricTypeComboBox.getValue();
        String name=metricNamefield.getText();
        String value=metricValueField.getText();
        LocalDate startDate=startDatePIcler.getValue();
        LocalDate endDate=endDatePicker.getValue();
        if(name.isEmpty()||value.isEmpty()||startDate==null||endDate==null||type==null){
            showAlert("Validation Error","All fields are required");
            return;
        }
        double val;
        try{
            val=Double.parseDouble(value);
        }catch(NumberFormatException e){
            showAlert("Validation Error","metric value must be numeric");
            return;
        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("metrics.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            //public OperationalMetrics(String metricType, String metricName, double metricValue, LocalDate startDate, LocalDate endDate)
            OperationalMetrics om=new OperationalMetrics(type,name,val,startDate,endDate);

            metricsTable.getItems().add(om);
            metricsList.add(om);
            oos.writeObject(om);
            metricNamefield.clear();
            metricValueField.clear();
            metricTypeComboBox.setValue(null);
            startDatePIcler.setValue(null);
            endDatePicker.setValue(null);

        }catch(IOException ex){
            Logger.getLogger(Goal5MonitorepzoperationalmetricsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal5MonitorepzoperationalmetricsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @javafx.fxml.FXML
    public void BackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/executivechairmanaDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void generateReportOnActionButton(ActionEvent actionEvent) {
        //StringBuilder report=new StringBuilder("Operational Metrics Report \n\n");
        String str="";
        for(OperationalMetrics o:metricsList){
            str=str+o.toString()+"\n";

        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operational Metrics Report");
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }
}