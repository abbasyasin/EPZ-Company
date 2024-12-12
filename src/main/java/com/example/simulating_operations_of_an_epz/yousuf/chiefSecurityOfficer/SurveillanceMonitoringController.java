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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.DatePicker;
import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SurveillanceMonitoringController
{

    @FXML
    private TextField cameraIdTextField;

    @FXML
    private ComboBox<String> livefieldStatusCombobox;
    @FXML
    private TableView<Surveillance> tableView;
    @FXML
    private TableColumn<Surveillance,String> liveStatusColumn;
    @FXML
    private TableColumn<Surveillance,String> areaMonitoredColumn;
    @FXML
    private TableColumn<Surveillance,Integer> cameraifColumn;
    @FXML
    private TextField areaTextField1;
    @FXML
    private DatePicker dateOfReport;
    @FXML
    private TableColumn<Surveillance, LocalDate> dateColumn;

    private File attatchfile;

    @javafx.fxml.FXML

    public void initialize() {
        livefieldStatusCombobox.getItems().addAll("Ok","Something Else");
        liveStatusColumn.setCellValueFactory(new PropertyValueFactory<Surveillance,String>("liveStatus"));
        areaMonitoredColumn.setCellValueFactory(new PropertyValueFactory<Surveillance,String>("areaMonitor"));
        cameraifColumn.setCellValueFactory(new PropertyValueFactory<Surveillance,Integer>("cameraId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Surveillance,LocalDate>("date"));
        loadAllStatus();

    }

    @javafx.fxml.FXML
    public void reportedFileButton(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        attatchfile= fileChooser.showOpenDialog(null);
    }

    @javafx.fxml.FXML
    public void addButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        int cameraId;
        if (cameraIdTextField.getText().isEmpty()){
            return;
        }else{
            cameraId=Integer.parseInt(cameraIdTextField.getText());
        }
        String cameraArea=areaTextField1.getText();
        if (cameraArea==null){
            return;
        }
        String liveStatus=livefieldStatusCombobox.getValue();
        if (liveStatus==null){
            return;
        }
        LocalDate date=dateOfReport.getValue();
        if (date==null){
            return;
        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("SurveillanceMonitoring.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Surveillance y=new Surveillance(cameraId,cameraArea,liveStatus,date);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(SurveillanceMonitoringController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(SurveillanceMonitoringController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        cameraIdTextField.clear();
        livefieldStatusCombobox.setValue(null);
        areaTextField1.clear();



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

    @FXML
    public void showAllButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        loadAllStatus();
    }

    public void loadAllStatus(){
        ObjectInputStream ois = null;
        try {
            Surveillance y;
            ois = new ObjectInputStream(new FileInputStream("SurveillanceMonitoring.bin"));
            while (true){
                y= (Surveillance) ois.readObject();
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

    @FXML
    public void showAllReportbutton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/attatchFile.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();}
}