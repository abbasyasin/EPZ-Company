package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VisitorManagementController {

    @FXML
    private TableColumn<Visitor, LocalDate> entryDateColumn;

    @FXML
    private DatePicker entryDatePicker;

    @FXML
    private TableColumn<Visitor, String> hostPErsonColumn;

    @FXML
    private TextField hostPersonTExtField;

    @FXML
    private TableColumn<Visitor, String> purposeOFVisitColumn;

    @FXML
    private TextField purposeOfVisitTExtfield;

    @FXML
    private TableView<Visitor> tableView;

    @FXML
    private TextField visitorNAmeTextfield;

    @FXML
    private TableColumn<Visitor, String> visitornameColumn;

    @FXML
    public void initialize() {
        visitornameColumn.setCellValueFactory(new PropertyValueFactory<Visitor,String>("visitorName"));
        hostPErsonColumn.setCellValueFactory(new PropertyValueFactory<Visitor,String>("hostPerson"));
        entryDateColumn.setCellValueFactory(new PropertyValueFactory<Visitor,LocalDate>("date"));
        purposeOFVisitColumn.setCellValueFactory(new PropertyValueFactory<Visitor,String>("visitOfPurpose"));
    }

    @FXML
    void addButton(ActionEvent event) {
        tableView.getItems().clear();
        String entryPerson=visitorNAmeTextfield.getText();
        if (entryPerson==null){
            return;
        }
        String purposeOfVisit=purposeOfVisitTExtfield.getText();
        if (purposeOfVisit==null){
            return;
        }
        LocalDate date=entryDatePicker.getValue();
        if (date==null){
            return;
        }
        String hostPurpose=hostPersonTExtField.getText();

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("VisitorManagement.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Visitor y=new Visitor(entryPerson,purposeOfVisit,date,hostPurpose);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(VisitorManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(VisitorManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        visitorNAmeTextfield.clear();
        purposeOfVisitTExtfield.clear();
        entryDatePicker.setValue(null);
        hostPersonTExtField.clear();


    }

    @FXML
    void backbutton(ActionEvent event)  throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/csODashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void showButton(ActionEvent event) {
        tableView.getItems().clear();
        loadVisitor();

    }
    public void loadVisitor(){
        ObjectInputStream ois = null;
        try {
            Visitor y;
            ois = new ObjectInputStream(new FileInputStream("VisitorManagement.bin"));
            while (true){
                y= (Visitor) ois.readObject();
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
