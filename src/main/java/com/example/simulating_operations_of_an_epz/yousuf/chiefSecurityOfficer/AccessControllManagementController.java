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

public class AccessControllManagementController {

    @FXML
    private ComboBox<String> AccessLAbelCombobox;

    @FXML
    private TableColumn<Accesscontroll, String> accesslavelColumn;

    @FXML
    private TableColumn<Accesscontroll, String> areaNameColumn;

    @FXML
    private TextField areaNameTExtfield;

    @FXML
    private TableColumn<Accesscontroll, LocalDate> dateColumn;

    @FXML
    private DatePicker datepickeR;

    @FXML
    private TableView<Accesscontroll> tableView;

    @FXML
    private TableColumn<Accesscontroll, Integer> userIdColumn;

    @FXML
    private TextField userIdTextField;

    @FXML
    public void initialize() {
        AccessLAbelCombobox.getItems().addAll(" Restricted","Limited","Full");
        accesslavelColumn.setCellValueFactory(new PropertyValueFactory<Accesscontroll,String>("accessLavel"));
        userIdColumn.setCellValueFactory(new PropertyValueFactory<Accesscontroll,Integer>("userId"));
        areaNameColumn.setCellValueFactory(new PropertyValueFactory<Accesscontroll,String>("AreaName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Accesscontroll,LocalDate>("date"));
        loadAllControl();

    }

    @FXML
    void applybutton(ActionEvent event) {
        tableView.getItems().clear();

        int userId;
        if (userIdTextField.getText().isEmpty()){
            return;
        }else{
            userId=Integer.parseInt(userIdTextField.getText());
        }
        String accessLabel=AccessLAbelCombobox.getValue();
        if (accessLabel==null){
            return;
        }
        String area=areaNameTExtfield.getText();
        if (area==null){
            return;
        }
        LocalDate date=datepickeR.getValue();
        if (date==null){
            return;
        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("AccessControlManagement.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Accesscontroll y=new Accesscontroll(userId,accessLabel,area,date);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(AccessControllManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(AccessControllManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        userIdTextField.clear();
        AccessLAbelCombobox.setValue(null);
        areaNameTExtfield.clear();
        datepickeR.setValue(null);


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
        tableView.getItems().clear();
        loadAllControl();

    }
    public void loadAllControl(){
        ObjectInputStream ois = null;
        try {
            Accesscontroll y;
            ois = new ObjectInputStream(new FileInputStream("AccessControlManagement.bin"));
            while (true){
                y= (Accesscontroll) ois.readObject();
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
