package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepeartmentalBudgetController {

    @FXML
    private TextField amounttextArea;

    @FXML
    private TableColumn<DepartmentBudget, Double> budgetColumn;

    @FXML
    private TableColumn<DepartmentBudget, String> depaermentcolumn;

    @FXML
    private ComboBox<String> departmentcombobox;

    @FXML
    private TableView<DepartmentBudget> tableview;
    @FXML
    private DatePicker yeardatePicker;
    @FXML
    private TableColumn<DepartmentBudget, LocalDate> yearColumn;

    @javafx.fxml.FXML
    public void initialize() {
        departmentcombobox.getItems().addAll("Finance Department","IT Department","Researcher","Security Department");
        budgetColumn.setCellValueFactory(new PropertyValueFactory<DepartmentBudget,Double>("amount"));
        depaermentcolumn.setCellValueFactory(new PropertyValueFactory<DepartmentBudget,String>("department"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<DepartmentBudget,LocalDate>("date"));
        loadDepartmentBudget();
    }


    @FXML
    void backButtonDbA(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Departmental Budget");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    public void createBudgetForDepartmentButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        loadDepartmentBudget();
    }

    @FXML
    public void addButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        String department=departmentcombobox.getValue();
        double amount=Double.parseDouble(amounttextArea.getText());
        LocalDate date=yeardatePicker.getValue();
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("departmentBudget.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            DepartmentBudget y=new DepartmentBudget(department,amount,date);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(DepeartmentalBudgetController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(DepeartmentalBudgetController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        departmentcombobox.setValue(null);
        amounttextArea.clear();
        yeardatePicker.setValue(null);
    }
    public void loadDepartmentBudget(){
        ObjectInputStream ois = null;
        try {
            DepartmentBudget y;
            ois = new ObjectInputStream(new FileInputStream("departmentBudget.bin"));
            while (true){
                y= (DepartmentBudget) ois.readObject();
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
