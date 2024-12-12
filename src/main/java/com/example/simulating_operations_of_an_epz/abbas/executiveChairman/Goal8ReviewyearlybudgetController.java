package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer.YearlyBudget;
import javafx.event.ActionEvent;
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

public class Goal8ReviewyearlybudgetController
{
    @javafx.fxml.FXML
    private ComboBox<String> CategoryComboBox;
    @javafx.fxml.FXML
    private TableView<RemarksOfYearlyReport> budgetRemarkTable;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfYearlyReport,LocalDate> budgetRemarkYearCol;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfYearlyReport,Double> budgetRemarkAmmountCol;
    @javafx.fxml.FXML
    private TextArea yearlyBudgetRemarksTextfield;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfYearlyReport,String> budgetRemarkCategoryCol;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfYearlyReport,Double> budgetRemarkPercentageCol;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfYearlyReport,String> budgetRemarksDescriptionCol;
    @javafx.fxml.FXML
    private TableView<YearlyBudget> tableViewDa;
    @javafx.fxml.FXML
    private TableColumn<YearlyBudget,LocalDate> yearColum;
    @javafx.fxml.FXML
    private TableColumn<YearlyBudget,Double> tableviewPercentageOfBudge;
    @javafx.fxml.FXML
    private TableColumn<YearlyBudget,String> tableVieCategory;
    @javafx.fxml.FXML
    private TableColumn<YearlyBudget,Double> tableVieAmount;

    @javafx.fxml.FXML
    public void initialize() {
        tableVieCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tableVieAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tableviewPercentageOfBudge.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        yearColum.setCellValueFactory(new PropertyValueFactory<>("year"));
        budgetRemarkCategoryCol.setCellValueFactory(new PropertyValueFactory<RemarksOfYearlyReport,String>("category"));
        budgetRemarkPercentageCol.setCellValueFactory(new PropertyValueFactory<RemarksOfYearlyReport,Double>("percentage"));
        budgetRemarkAmmountCol.setCellValueFactory(new PropertyValueFactory<RemarksOfYearlyReport,Double>("amount"));
        budgetRemarkYearCol.setCellValueFactory(new PropertyValueFactory<RemarksOfYearlyReport,LocalDate>("year"));
        budgetRemarksDescriptionCol.setCellValueFactory(new PropertyValueFactory<RemarksOfYearlyReport,String>("remarks"));
        storeCategoryComboBox();
        YearlyBudgets();
    }

    public void storeCategoryComboBox(){
        ObjectInputStream ois = null;
        try {
            YearlyBudget y;
            ois = new ObjectInputStream(new FileInputStream("yearlybudget.bin"));
            while (true){
                y= (YearlyBudget) ois.readObject();
                CategoryComboBox.getItems().add(y.getCategory());
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


    @javafx.fxml.FXML
    public void addYearlyBudgetRemark(ActionEvent actionEvent) {
        String category = CategoryComboBox.getValue();
        String remark= yearlyBudgetRemarksTextfield.getText();
        if(category.isEmpty() || remark.isEmpty()){
            showAlert("Validation Error","All Fields Are Required");
            return;
        }
        ObjectInputStream ois = null;
        try {
            YearlyBudget m;
            ois = new ObjectInputStream(new FileInputStream("yearlybudget.bin"));
            while (true){
                m= (YearlyBudget) ois.readObject();
                if(m.getCategory().equals(category)){
                    RemarksOfYearlyReport re=new RemarksOfYearlyReport(m.getCategory(),m.getPercentage(),m.getAmount(),m.getYear(),remark);
                    writeRemark(re);
                }
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

    @javafx.fxml.FXML
    public void loadAllYealyBudgetRemark(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal8b_reviewyearlybudget.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/executivechairmanaDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    public void YearlyBudgets(){
        ObjectInputStream ois = null;
        try {
            YearlyBudget y;
            ois = new ObjectInputStream(new FileInputStream("yearlybudget.bin"));
            while (true){
                y= (YearlyBudget) ois.readObject();
                tableViewDa.getItems().add(y);
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
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void writeRemark(RemarksOfYearlyReport remarksBudget){
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("remarksyearlybudget.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(remarksBudget);
            budgetRemarkTable.getItems().add(remarksBudget);
            CategoryComboBox.setValue(null);
            yearlyBudgetRemarksTextfield.clear();


        }catch(IOException ex){
            Logger.getLogger(Goal8ReviewyearlybudgetController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal8ReviewyearlybudgetController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

}