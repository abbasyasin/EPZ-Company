package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

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

public class SendMessageController {

    @FXML
    private TableColumn<SendMessage, Integer>employeeIdColumn;

    @FXML
    private TableView<SendMessage> tableView;

    @FXML
    private TableColumn<SendMessage, String> typeMEssageColumn;

    @FXML
    private TextField typeMessageTextField;
    @FXML
    private ComboBox<Integer> employeeIdCombobox;
    @FXML
    private TableColumn<SendMessage,String> emailaddressColumn1;
    @FXML
    private TextField emailaddressTextField1;

    @javafx.fxml.FXML
    public void initialize() {
        employeeIdCombobox.getItems().addAll(2222455,344556,222041,2010025,2221111,20102047,110000,222000,12000,22000);
        emailaddressColumn1.setCellValueFactory(new PropertyValueFactory<SendMessage,String>("emailAddress"));
        typeMEssageColumn.setCellValueFactory(new PropertyValueFactory<SendMessage,String>("typeMessage"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<SendMessage,Integer>("employeeId"));
        messageLoad();

    }

    @javafx.fxml.FXML
    public void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();}

    @javafx.fxml.FXML
    public void addbutton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        int employeeId;
        if (employeeIdCombobox.getItems().isEmpty()){
            return;
        }else{
            employeeId=employeeIdCombobox.getValue();

        }
        String typeMEssage=typeMessageTextField.getText();
        if (typeMEssage==null){
            return;
        }
        String emailaddress=emailaddressTextField1.getText();
        if (emailaddress==null){
            return;
        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("SendMessage.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            SendMessage y=new SendMessage(employeeId,typeMEssage,emailaddress);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(SendMessageController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(SendMessageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        employeeIdCombobox.setValue(null);
        typeMessageTextField.clear();
        emailaddressTextField1.clear();

    }

    @javafx.fxml.FXML
    public void addAndShowButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        messageLoad();
    }
    public void messageLoad(){

        ObjectInputStream ois = null;
        try {
            SendMessage y;
            ois = new ObjectInputStream(new FileInputStream("SendMessage.bin"));
            while (true){
                y= (SendMessage) ois.readObject();
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