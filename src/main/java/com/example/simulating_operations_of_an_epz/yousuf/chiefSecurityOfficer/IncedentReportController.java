package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IncedentReportController
{
    @FXML
    private ComboBox<String>incidentTypecombobox;
    @FXML
    private TextField incidentIdTextField;
    @FXML
    private TextField reportedByTExtfield;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TableColumn<IncidentReport,Integer> incidentIdColumn;
    @FXML
    private TableView<IncidentReport> tableview;
    @FXML
    private TableColumn<IncidentReport,String> incidentTypecolumn;
    @FXML
    private TableColumn<IncidentReport, LocalDate> datecolumn;
    @FXML
    private TableColumn<IncidentReport,String> reportedColumn;

    @javafx.fxml.FXML
    public void initialize() {
        incidentTypecombobox.getItems().addAll("Theft","Trespass","Vandalism");
        reportedColumn.setCellValueFactory(new PropertyValueFactory<IncidentReport,String>("reportedBy"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<IncidentReport,LocalDate>("date"));
        incidentTypecolumn.setCellValueFactory(new PropertyValueFactory<IncidentReport,String>("incidentType"));
        incidentIdColumn.setCellValueFactory(new PropertyValueFactory<IncidentReport,Integer>("incidentId"));
        incidentreportView();

    }

    @javafx.fxml.FXML
    public void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/csODashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void showbutton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        incidentreportView();
    }

    @javafx.fxml.FXML
    public void addButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        String incidentIdText=incidentIdTextField.getText();
        int incidentId=Integer.parseInt(incidentIdText);
        if (incidentIdText.isEmpty()){
            return;
        }
        String reportedBy=reportedByTExtfield.getText();
        if (reportedBy==null){
            return;
        }
        String incidentType=incidentTypecombobox.getValue();
        if (incidentType==null){
            return;
        }
        LocalDate date=datepicker.getValue();
        if (date==null){
            return;
        }
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("incidentReport.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            IncidentReport y=new IncidentReport(incidentId,incidentType,date,reportedBy);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(IncedentReportController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(IncedentReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        incidentIdTextField.clear();
        reportedByTExtfield.clear();
        incidentTypecombobox.setValue(null);
        datepicker.setValue(null);
    }
    public void incidentreportView(){
        ObjectInputStream ois = null;
        try {
            IncidentReport y;
            ois = new ObjectInputStream(new FileInputStream("incidentReport.bin"));
            while (true){
                y= (IncidentReport) ois.readObject();
                tableview.getItems().add(y);
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