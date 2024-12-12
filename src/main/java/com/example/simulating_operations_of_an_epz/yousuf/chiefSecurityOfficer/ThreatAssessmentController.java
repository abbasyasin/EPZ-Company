package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreatAssessmentController
{
    @javafx.fxml.FXML
    private ComboBox<String> riskLabelCombobox;
    @javafx.fxml.FXML
    private TextField descriptionTextField;
    @javafx.fxml.FXML
    private TextField threadIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> threattypeComboBox;
    @FXML
    private TableView<ThreatAssetment> tableView;
    @FXML
    private TableColumn<ThreatAssetment,String> threatTypeColumn;
    @FXML
    private TableColumn<ThreatAssetment,Integer> ThreatIdcolumn;
    @FXML
    private TableColumn<ThreatAssetment,String> riskLavelcolumn;
    @FXML
    private TableColumn<ThreatAssetment,String> describtionColumn;

    @javafx.fxml.FXML
    public void initialize() {
        threattypeComboBox.getItems().addAll(" Cyber","Physical","Operational");
        riskLabelCombobox.getItems().addAll(" Low","Medium", "High");
        threatTypeColumn.setCellValueFactory(new PropertyValueFactory<ThreatAssetment,String>("threatType"));
        ThreatIdcolumn.setCellValueFactory(new PropertyValueFactory<ThreatAssetment,Integer>("threatId"));
        riskLavelcolumn.setCellValueFactory(new PropertyValueFactory<ThreatAssetment,String>("riskLabel "));
        describtionColumn.setCellValueFactory(new PropertyValueFactory<ThreatAssetment,String>("describtion"));
        loadThreat();


    }

    @javafx.fxml.FXML
    public void saveReportButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        loadThreat();
    }

    @javafx.fxml.FXML
    public void addbutton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        int threatId;
        if (threadIdTextField.getText().isEmpty()){
            return;
        }else{
            threatId=Integer.parseInt(threadIdTextField.getText());
        }
        String threatType=threattypeComboBox.getValue();
        if (threatType==null){
            return;
        }
        String risklabel=riskLabelCombobox.getValue();
        if (risklabel==null){
            return;
        }
        String describtion=descriptionTextField.getText();
        if (describtion==null){
            return;
        }
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("ThreatAssessment.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            ThreatAssetment y=new ThreatAssetment(threatId,threatType,risklabel,describtion);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(ThreatAssessmentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(ThreatAssessmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        threadIdTextField.clear();
        threattypeComboBox.setValue(null);
        riskLabelCombobox.setValue(null);
        descriptionTextField.clear();

    }

    @FXML
    public void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/csODashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }
    public void loadThreat(){
        ObjectInputStream ois = null;
        try {
            ThreatAssetment y;
            ois = new ObjectInputStream(new FileInputStream("ThreatAssessment.bin"));
            while (true){
                y= (ThreatAssetment) ois.readObject();
                tableView.getItems().add(y);
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