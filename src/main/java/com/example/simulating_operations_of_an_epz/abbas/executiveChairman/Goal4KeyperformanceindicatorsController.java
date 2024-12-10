package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

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

public class Goal4KeyperformanceindicatorsController
{
    @javafx.fxml.FXML
    private TableColumn<KPI, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TextField targetValueTextField;
    @javafx.fxml.FXML
    private TableColumn<KPI,Double> actualValueCol;
    @javafx.fxml.FXML
    private TextField kpiNameTextField;
    @javafx.fxml.FXML
    private TextArea DescriptionTextfield;
    @javafx.fxml.FXML
    private TableColumn<KPI,String> kpiNameCol;
    @javafx.fxml.FXML
    private TableView<KPI> kpiTable;
    @javafx.fxml.FXML
    private DatePicker datepicker;
    @javafx.fxml.FXML
    private TableColumn<KPI,Double> targetValueCol;
    @javafx.fxml.FXML
    private TextField actualValueTextField;
    @javafx.fxml.FXML
    private TableColumn<KPI,String> descriptionCol;

    @javafx.fxml.FXML
    public void initialize() {
        kpiNameCol.setCellValueFactory(new PropertyValueFactory<KPI,String>("kpiName"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<KPI,String>("description"));
        targetValueCol.setCellValueFactory(new PropertyValueFactory<KPI,Double>("targetValue"));
        actualValueCol.setCellValueFactory(new PropertyValueFactory<KPI,Double>("actualValue"));
        dateCol.setCellValueFactory(new PropertyValueFactory<KPI,LocalDate>("date"));
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/executivechairmanaDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void addKPIOnActionButton(ActionEvent actionEvent) {
        String kpiName = kpiNameTextField.getText();
        String description = DescriptionTextfield.getText();
        LocalDate date = datepicker.getValue();
        double targetValue,actualValue;
        try{
            targetValue = Double.parseDouble(targetValueTextField.getText());
            actualValue = Double.parseDouble(actualValueTextField.getText());
        } catch (NumberFormatException e) {
            showAlert("Validation Error","target value and actual value must be numeric");
            return;
        }
        if(kpiName.isEmpty()||description.isEmpty()||date==null){
            showAlert("Validation Error","All feilds are required");
            return;
        }
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("kpirecords.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            //public KPI(String kpiName, String description, double targetValue, double actualValue, LocalDate date)
            KPI kpi=new KPI(kpiName,description,targetValue,actualValue,date);
            kpiTable.getItems().add(kpi);
            oos.writeObject(kpi);
            kpiNameTextField.clear();
            DescriptionTextfield.clear();
            targetValueTextField.clear();
            actualValueTextField.clear();
            datepicker.setValue(null);

        }catch(IOException ex){
            Logger.getLogger(Goal4KeyperformanceindicatorsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal4KeyperformanceindicatorsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @javafx.fxml.FXML
    public void loadAllKPIOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal4b_keyperformanceindicators.fxml")));
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

}