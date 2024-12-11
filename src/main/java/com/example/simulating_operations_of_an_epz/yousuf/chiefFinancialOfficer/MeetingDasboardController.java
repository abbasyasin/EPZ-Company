package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

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

public class MeetingDasboardController {

    @FXML
    private ComboBox<Integer> employeeIdCombobox;

    @FXML
    private DatePicker meetingTimeAndDateDatepicker;

    @FXML
    private TextField meetingTitleTextArea;
    @FXML
    private TableColumn<Meeting, LocalDate> timeandDateColumn;
    @FXML
    private TableView<Meeting> tableView;
    @FXML
    private TableColumn<Meeting,Integer> employeeColumn;
    @FXML
    private TableColumn<Meeting,String> meetingColumn;
    @FXML
    private TextField mobileNumberTextArea1;
    @FXML
    private TableColumn<Meeting,Integer> mobilenumberColumn1;

    @FXML
    public void initialize() {
        employeeIdCombobox.getItems().addAll(2222455,344556,222041,2010025,2221111,20102047,110000,222000,12000,22000);
        mobilenumberColumn1.setCellValueFactory(new PropertyValueFactory<Meeting,Integer>("mobileNumber"));
        employeeColumn.setCellValueFactory(new PropertyValueFactory<Meeting,Integer>("employeeId"));
        meetingColumn.setCellValueFactory(new PropertyValueFactory<Meeting,String>("meetingTitle"));
        timeandDateColumn.setCellValueFactory(new PropertyValueFactory<Meeting,LocalDate>("date"));
        meetingloader();
    }

    @FXML
    void addButton(ActionEvent event) {
        tableView.getItems().clear();
        int employeeId;
        if (employeeIdCombobox.getItems().isEmpty()){
            return;
        }else{
            employeeId=employeeIdCombobox.getValue();
        }
        String meeting=meetingTitleTextArea.getText();
        if (meeting==null){
            return;
        }
        LocalDate date=meetingTimeAndDateDatepicker.getValue();
        if (date==null){
            return;
        }
        int mobileno=Integer.parseInt(mobileNumberTextArea1.getText());
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("MeetingDate.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Meeting y=new Meeting(employeeId,meeting,date,mobileno);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(MeetingDasboardController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(MeetingDasboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        employeeIdCombobox.setValue(null);
        meetingTitleTextArea.clear();
        mobileNumberTextArea1.clear();

    }

    @FXML
    void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();}

    @FXML
    void callForMeetingButton(ActionEvent event) {
        tableView.getItems().clear();
        meetingloader();

    }
    public void meetingloader(){
        ObjectInputStream ois = null;
        try {
            Meeting y;
            ois = new ObjectInputStream(new FileInputStream("MeetingDate.bin"));
            while (true){
                y= (Meeting) ois.readObject();
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
