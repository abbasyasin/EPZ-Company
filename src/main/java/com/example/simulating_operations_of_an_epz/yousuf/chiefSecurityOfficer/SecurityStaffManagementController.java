package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecurityStaffManagementController {

    @FXML
    private TableColumn<SecurityStaff, String> roleColumn;

    @FXML
    private ComboBox<String> rolecombobox;

    @FXML
    private TableColumn<SecurityStaff, String> shifttimingColumn;

    @FXML
    private TextField shifttimingTextField;

    @FXML
    private TableColumn<SecurityStaff, Integer> staffIdColumn;

    @FXML
    private TextField staffIdTExtfield;

    @FXML
    private TableColumn<SecurityStaff, String> staffNameColumn;

    @FXML
    private TextField staffNameTextField;

    @FXML
    private TableView<SecurityStaff> tableview;


    @FXML
    public void initialize() {
        rolecombobox.getItems().addAll("Guard","Patrol","Control Room");
        staffNameColumn.setCellValueFactory(new PropertyValueFactory<SecurityStaff,String>("staffName"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<SecurityStaff,Integer>("staffId"));
        shifttimingColumn.setCellValueFactory(new PropertyValueFactory<SecurityStaff,String>("time"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<SecurityStaff,String>("role"));
        loadSecurityController();

    }

    @FXML
    void applyButton(ActionEvent event) {
        tableview.getItems().clear();
        int staffId;
        if (staffIdTExtfield.getText().isEmpty()){
            return;
        }else{staffId=Integer.parseInt(staffIdTExtfield.getText());
        }
        String staffName=staffNameTextField.getText();
        if (staffName==null){
            return;
        }
        String time=shifttimingTextField.getText();
        if (time==null){
            return;
        }
        String role=rolecombobox.getValue();
        if (role==null){
            return;
        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("SecurityStaffManagement.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            SecurityStaff y=new SecurityStaff(staffId,staffName,role,time);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(SecurityStaffManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(SecurityStaffManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        staffNameTextField.clear();
        staffIdTExtfield.clear();
        rolecombobox.setValue(null);
    }

    @FXML
    void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/csODashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void showbutton(ActionEvent event) {
        tableview.getItems().clear();
        loadSecurityController();

    }
    public void loadSecurityController(){
        ObjectInputStream ois = null;
        try {
            SecurityStaff y;
            ois = new ObjectInputStream(new FileInputStream("SecurityStaffManagement.bin"));
            while (true){
                y= (SecurityStaff) ois.readObject();
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
