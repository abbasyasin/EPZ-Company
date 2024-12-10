package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

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

public class UpdatePolicyController {

    @FXML
    private TableColumn<UpdatePolicy, String> PolicyDescription;

    @FXML
    private TableColumn<UpdatePolicy, LocalDate> effectiveDateColumn;

    @FXML
    private DatePicker effectiveDatePicker;

    @FXML
    private TextField policyDescription;

    @FXML
    private TextField policyIdTExtfield;

    @FXML
    private TableColumn<UpdatePolicy, String> policytitleColumn;

    @FXML
    private TextField policytitleTextField;

    @FXML
    private TableView<UpdatePolicy> tableView;
    @FXML
    private TableColumn<UpdatePolicy,Integer> policyIDColumn;


    @javafx.fxml.FXML
    public void initialize() {
        policyIDColumn.setCellValueFactory(new PropertyValueFactory<UpdatePolicy,Integer>("policyId"));
        policytitleColumn.setCellValueFactory(new PropertyValueFactory<UpdatePolicy,String>("policyTitle"));
        PolicyDescription.setCellValueFactory(new PropertyValueFactory<UpdatePolicy,String>("policyDescription"));
        effectiveDateColumn.setCellValueFactory(new PropertyValueFactory<UpdatePolicy,LocalDate>("date"));
        loadpolicy();

    }

    @FXML
    void addAndClear(ActionEvent event) {
        tableView.getItems().clear();
        int policyID;
        if (policyIdTExtfield.getText().isEmpty()){
            return;
        }else{
            policyID=Integer.parseInt(policyIdTExtfield.getText());

        }
        String policyTitle;
        if (policytitleTextField.getText().isEmpty()){
            return;
        }else{
            policyTitle=policytitleTextField.getText();

        }
        String policyDes;
        if (policyDescription.getText().isEmpty()){
            return;
        }else{
            policyDes=policyDescription.getText();

        }
        LocalDate date=effectiveDatePicker.getValue();
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("updatepolicy.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            UpdatePolicy y=new UpdatePolicy(policyID,policyTitle,policyDes,date);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(UpdatePolicyController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(UpdatePolicyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        policytitleTextField.clear();
        policyDescription.clear();
        policyIdTExtfield.clear();
        policyDescription.clear();
        effectiveDatePicker.setValue(null);

    }

    @FXML
    public void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();}

    @FXML
    public void updatePolicyAndShowButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        loadpolicy();

    }
    public void loadpolicy(){
        ObjectInputStream ois = null;
        try {
            UpdatePolicy y;
            ois = new ObjectInputStream(new FileInputStream("updatepolicy.bin"));
            while (true){
                y= (UpdatePolicy) ois.readObject();
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
