package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.Goal1StrategicgoalsController;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.StrategicGoal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class YearlyBudgetAllocatedController {

    @FXML
    private TextField amountTextArea;

    @FXML
    private ComboBox<String> categoryCombobox;

    @FXML
    private TextField percentageOFTExtArea;

    @FXML
    private TableColumn<YearlyBudget,Double> tableViewAmount;

    @FXML
    private TableColumn<YearlyBudget,String> tableViewCategory;

    @FXML
    private TableView<YearlyBudget> tableViewData;

    @FXML
    private TableColumn<YearlyBudget,Double> tableviewPercentageOfBudget;


    public void initialize() {
        categoryCombobox.getItems().addAll("Salaries","Logistics","Utilities","Operation","Miscellaneous");
        tableViewCategory.setCellValueFactory(new PropertyValueFactory<YearlyBudget,String>("category"));
        tableViewAmount.setCellValueFactory(new PropertyValueFactory<YearlyBudget,Double>("amount"));
        tableviewPercentageOfBudget.setCellValueFactory(new PropertyValueFactory<YearlyBudget,Double>("percentage"));
        loadBudgets();

    }


    @FXML
    void backButtonYearlyBudget(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }


    @FXML
    public void addBudgetBUtton(ActionEvent actionEvent) {
        tableViewData.getItems().clear();
        String category=categoryCombobox.getValue();
        double percentage=Double.parseDouble(percentageOFTExtArea.getText());
        double ammount=Double.parseDouble(amountTextArea.getText());
        double estimatedAmount=getCalculatedAmmount(percentage,ammount);
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("yearlybudget.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            YearlyBudget y=new YearlyBudget(category,percentage,estimatedAmount);
            tableViewData.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(YearlyBudgetAllocatedController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(YearlyBudgetAllocatedController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        categoryCombobox.setValue(null);
        percentageOFTExtArea.clear();


    }

    public double getCalculatedAmmount(Double percentage,Double amount){
        double estimatedAmount=amount*(percentage/100);
        return estimatedAmount;

    }

    @FXML
    public void showAllButton(ActionEvent actionEvent) {
        tableViewData.getItems().clear();
        loadBudgets();
    }

    private void loadBudgets(){
        ObjectInputStream ois = null;
        try {
            YearlyBudget y;
            ois = new ObjectInputStream(new FileInputStream("yearlybudget.bin"));
            while (true){
                y= (YearlyBudget) ois.readObject();
                tableViewData.getItems().add(y);
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
