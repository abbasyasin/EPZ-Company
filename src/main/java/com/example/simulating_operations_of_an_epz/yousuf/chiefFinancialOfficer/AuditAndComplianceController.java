package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuditAndComplianceController {

    @FXML
    private TableColumn<Audit, LocalDate> auditDate;

    @FXML
    private TextField auditIDTextField;

    @FXML
    private TableColumn<Audit, Integer> auditIdColumn;

    @FXML
    private TableColumn<Audit, String> auditTypeColumn;

    @FXML
    private ComboBox<String> auditTypeCombobox;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TableColumn<Audit, String> departmenColumn;

    @FXML
    private ComboBox<String> departmentCombobox;

    @FXML
    private TableView<Audit> tableView;

    @FXML
    public void initialize() {
        departmentCombobox.getItems().addAll("Finance Department","IT Department","Researcher","Security Department");
        auditTypeCombobox.getItems().addAll(" Financial", "Operational", "Compliance");
        departmenColumn.setCellValueFactory(new PropertyValueFactory<Audit,String>("auditDepartment"));
        auditTypeColumn.setCellValueFactory(new PropertyValueFactory<Audit,String>("auditType"));
        auditIdColumn.setCellValueFactory(new PropertyValueFactory<Audit,Integer>("auditId"));
        auditDate.setCellValueFactory(new PropertyValueFactory<Audit,LocalDate>("date"));
        loadAudit();
    }

    @FXML
    void addButton(ActionEvent event) {
        tableView.getItems().clear();
        int auditId;
        if (auditIDTextField.getText().isEmpty()){
            return;
        }else{
            auditId=Integer.parseInt(auditIDTextField.getText());
        }
        String auditType=auditTypeCombobox.getValue();
        if (auditType.isEmpty()){
            return;
        }
        String department=departmentCombobox.getValue();
        if (department.isEmpty()){
            return;
        }
        LocalDate date=datepicker.getValue();


        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("AuditAndCompliance.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Audit y=new Audit(auditId,auditType,department,date);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(AuditAndComplianceController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(AuditAndComplianceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        auditIDTextField.clear();
        auditTypeCombobox.setValue(null);
        departmentCombobox.setValue(null);
        datepicker.setValue(null);



    }

    @FXML
    void showAll(ActionEvent event) {
        tableView.getItems().clear();
        loadAudit();

    }
    public void loadAudit(){
        ObjectInputStream ois = null;
        try {
            Audit y;
            ois = new ObjectInputStream(new FileInputStream("AuditAndCompliance.bin"));
            while (true){
                y= (Audit) ois.readObject();
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
