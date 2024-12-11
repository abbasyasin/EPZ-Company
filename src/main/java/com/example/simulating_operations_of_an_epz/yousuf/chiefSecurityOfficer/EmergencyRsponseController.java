package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmergencyRsponseController {

    @FXML
    private ComboBox<String> contactNumbercombobox;

    @FXML
    private TableColumn<EmergencyTeam, String> contactnumberColumn;

    @FXML
    private ComboBox<String> emergencyCombobox;

    @FXML
    private TableColumn<EmergencyTeam, String> emergencyTypeColumn;

    @FXML
    private TableColumn<EmergencyTeam, Integer> planIdcolumn;

    @FXML
    private TextField planIdtextField;

    @FXML
    private TableColumn<EmergencyTeam, String> responseTeamColumn;

    @FXML
    private ComboBox<String> responseteamcombobox;

    @FXML
    private TableView<EmergencyTeam> tableView;
    private ArrayList<Numbers> number;

    @FXML
    public void initialize() {
        number=new ArrayList<>();
        emergencyCombobox.getItems().addAll("Fire", "Medical", "Evacuation");
        responseteamcombobox.getItems().addAll("Yousuf","Nibir","Abbas","Ratna","Turan","Tasfiq","Rakin");
        contactNumbercombobox.getItems().addAll("01732231661","017322131771","01732528509","01791968885","01922808778","01727279644","01887887861");
        responseTeamColumn.setCellValueFactory(new PropertyValueFactory<EmergencyTeam,String>("responseTeamMember"));
        emergencyTypeColumn.setCellValueFactory(new PropertyValueFactory<EmergencyTeam,String>("emergencyType"));
        planIdcolumn.setCellValueFactory(new PropertyValueFactory<EmergencyTeam,Integer>("planId"));
        contactnumberColumn.setCellValueFactory(new PropertyValueFactory<EmergencyTeam,String>("mobileNumber"));
        loadEmergency();

    }

    @FXML
    void addButton(ActionEvent event) {
        tableView.getItems().clear();
        int planId;
        if (planIdtextField.getText().isEmpty()){
            return;
        }else{
            planId=Integer.parseInt(planIdtextField.getText());
        }
        String contactNumber;
        if (contactNumbercombobox.getItems().isEmpty()){
            return;
        }else{
            contactNumber=contactNumbercombobox.getValue();
        }
        String emergencytype=emergencyCombobox.getValue();
        if (emergencytype==null){
            return;
        }
        String responseTeamMember=responseteamcombobox.getValue();
        if (responseTeamMember==null){
            return;
        }
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("EmergencyResponse.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            EmergencyTeam y=new EmergencyTeam(planId,emergencytype,contactNumber,responseTeamMember);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(EmergencyRsponseController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(EmergencyRsponseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        planIdtextField.clear();
        contactNumbercombobox.setValue(null);
        emergencyCombobox.setValue(null);
        responseteamcombobox.setValue(null);
    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/csODashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void emergencybutton(ActionEvent event) {
        number=new ArrayList<>();
        String fireServiceNumber= "102";
        String emergencyNumber="999";
        String dutyOfficer="191";
        String chairman="89";
        String policeNumber="919";
        Numbers temp=new Numbers(fireServiceNumber,emergencyNumber,dutyOfficer,chairman,policeNumber);
        number.add(temp);
        Numbers num = number.get(0);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Emergency Information");
        a.setHeaderText("Emergency Numbers");
        String content = "Fire Service Number: " + num.getFireServiceNumber() + "\n"
                + "Emergency Number: " + num.getEmergencyNumber() + "\n"
                + "Duty Officer: " + num.getDutyOfficer() + "\n"
                + "Chairman: " + num.getChairman() + "\n"
                + "Police Number: " + num.getPoliceNumber();
        a.setContentText(content);
        a.showAndWait();
    }

    @FXML
    void showButton(ActionEvent event) {
        tableView.getItems().clear();
        loadEmergency();

    }
    public void loadEmergency(){
        ObjectInputStream ois = null;
        try {
            EmergencyTeam y;
            ois = new ObjectInputStream(new FileInputStream("EmergencyResponse.bin"));
            while (true){
                y= (EmergencyTeam) ois.readObject();
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
