package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

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
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SkillsDevolapmentWorkshopController {

    @FXML
    private TableColumn<SkillDevelopment, LocalDate> dateColumn;

    @FXML
    private TableColumn<SkillDevelopment, Integer> employeeIdColumn;

    @FXML
    private ComboBox<Integer> employeecombobox;

    @FXML
    private TableColumn<SkillDevelopment, String> skillsColumn;

    @FXML
    private DatePicker workShopDatePicker;

    @FXML
    private TextField workShopTitletextfield;

    @FXML
    private TableColumn<SkillDevelopment, String> workshoptitleColumn;
    @FXML
    private TableView<SkillDevelopment> tableColumn;
    @FXML
    private ComboBox<String> skillsComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        employeecombobox.getItems().addAll(2222455,344556,222041,2010025,2221111,20102047,110000,222000,12000,22000);
        skillsComboBox.getItems().addAll("Communication skill","Writing skill","Reading Skill","Presentation skill","Language skill");
        dateColumn.setCellValueFactory(new PropertyValueFactory<SkillDevelopment,LocalDate>("date"));
        workshoptitleColumn.setCellValueFactory(new PropertyValueFactory<SkillDevelopment,String>("workshopTitle"));
        skillsColumn.setCellValueFactory(new PropertyValueFactory<SkillDevelopment,String>("skill"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<SkillDevelopment,Integer>("employeeId"));

        skillsDev();
    }

    @FXML
    void addButton(ActionEvent event) {
        tableColumn.getItems().clear();
        String workshopTitle;
        if (workShopTitletextfield.getText().isEmpty()){
            return;
        }else{
            workshopTitle=workShopTitletextfield.getText();
        }
        int employeeId;
        if (employeecombobox.getItems().isEmpty()){
            return;
        }else{
            employeeId=employeecombobox.getValue();
        }
        LocalDate date=workShopDatePicker.getValue();
        if (date==null){
            return;
        }
        String skill=skillsComboBox.getValue();
        if (skill==null){
            return;
        }
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("SkillDevelopment.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            SkillDevelopment y=new SkillDevelopment(workshopTitle,employeeId,date,skill);
            tableColumn.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(SkillDevelopment.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(SkillDevelopment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        employeecombobox.setValue(null);
        workShopDatePicker.setValue(null);
        skillsComboBox.setValue(null);
    }

    @FXML
    void showButton(ActionEvent event) {
        tableColumn.getItems().clear();
        skillsDev();

    }

    public void skillsDev(){
        ObjectInputStream ois = null;
        try {
            SkillDevelopment y;
            ois = new ObjectInputStream(new FileInputStream("SkillDevelopment.bin"));
            while (true){
                y= (SkillDevelopment) ois.readObject();
                tableColumn.getItems().add(y);
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
    public void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();}
}
