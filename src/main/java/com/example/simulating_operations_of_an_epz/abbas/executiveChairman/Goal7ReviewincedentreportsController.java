package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer.IncidentReport;
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

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Goal7ReviewincedentreportsController {
    @javafx.fxml.FXML
    private ComboBox<Integer> reportIdComboBox;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfIncidentReport,LocalDate> remarksdateCol;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfIncidentReport,String> remarksTypeCol;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfIncidentReport,Integer> remarksIdCol;
    @javafx.fxml.FXML
    private TextArea incedentremarksTextArea;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfIncidentReport,String> remarksReportedByCol;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfIncidentReport,String> remarkdescriptionCol;
    @javafx.fxml.FXML
    private TableView<RemarksOfIncidentReport> remarksTable;
    ObservableList<IncidentReport> reviewIncidentReports= FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TableView<IncidentReport> tablevie;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport,Integer> incidentIdColum;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport,LocalDate> datecolum;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport,String> reportedColum;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport,String> incidentTypecolum;

    @javafx.fxml.FXML
    public void initialize() {
        remarksIdCol.setCellValueFactory(new PropertyValueFactory<RemarksOfIncidentReport,Integer>("incidentId"));
        remarksTypeCol.setCellValueFactory(new PropertyValueFactory<RemarksOfIncidentReport,String>("incidentType"));
        remarksdateCol.setCellValueFactory(new PropertyValueFactory<RemarksOfIncidentReport,LocalDate>("date"));
        remarksReportedByCol.setCellValueFactory(new PropertyValueFactory<RemarksOfIncidentReport,String>("reportedBy"));
        remarkdescriptionCol.setCellValueFactory(new PropertyValueFactory<RemarksOfIncidentReport,String>("remarks"));
        reportedColum.setCellValueFactory(new PropertyValueFactory<>("reportedBy"));
        datecolum.setCellValueFactory(new PropertyValueFactory<>("date"));
        incidentTypecolum.setCellValueFactory(new PropertyValueFactory<>("incidentType"));
        incidentIdColum.setCellValueFactory(new PropertyValueFactory<>("incidentId"));
        storeIDComboBox();
        incidentReports();
    }

    public void storeIDComboBox(){
        ObjectInputStream ois = null;
        try {
            IncidentReport y;
            ois = new ObjectInputStream(new FileInputStream("incidentReport.bin"));
            while (true){
                y= (IncidentReport) ois.readObject();
                reportIdComboBox.getItems().add(y.getIncidentId());
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

    @javafx.fxml.FXML
    public void generateReportOnActionButton(ActionEvent actionEvent) {
        int id = reportIdComboBox.getValue();
        String remarks=incedentremarksTextArea.getText();
        if(reportIdComboBox.getValue() == null || remarks.isEmpty()){
            showAlert("Validation Error","All fields are required");
            return;
        }
        ObjectInputStream ois = null;
        try {
            IncidentReport y;
            ois = new ObjectInputStream(new FileInputStream("incidentReport.bin"));
            while (true){
                y= (IncidentReport) ois.readObject();
                if(y.getIncidentId() == id){
                    //reviewIncidentReports.add(y);
                    RemarksOfIncidentReport r=new RemarksOfIncidentReport(id,y.getIncidentType(),y.getDate(),y.getReportedBy(),remarks);
                    writeReport(r);

                }
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

    public void writeReport(RemarksOfIncidentReport remarksReport){
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("remarksincedentreport.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(remarksReport);
            remarksTable.getItems().add(remarksReport);
            reportIdComboBox.setValue(null);
            incedentremarksTextArea.clear();


        }catch(IOException ex){
            Logger.getLogger(Goal7ReviewincedentreportsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal7ReviewincedentreportsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void showAllreportsOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal7b_reviewincedentreports.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
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

    public void incidentReports(){
        ObjectInputStream ois = null;
        try {
            IncidentReport y;
            ois = new ObjectInputStream(new FileInputStream("incidentReport.bin"));
            while (true){
                y= (IncidentReport) ois.readObject();
                tablevie.getItems().add(y);
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