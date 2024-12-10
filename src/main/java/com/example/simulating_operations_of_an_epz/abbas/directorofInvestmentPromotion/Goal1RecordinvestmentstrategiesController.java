package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.Goal1StrategicgoalsController;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.StrategicGoal;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Goal1RecordinvestmentstrategiesController
{
    @javafx.fxml.FXML
    private TextField strategyNameField;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy,String> highPriorityCol;
    @javafx.fxml.FXML
    private TableView<InvestmentStrategy> investmentStrategyTable;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy, LocalDate> dateCol;
    @javafx.fxml.FXML
    private ComboBox<String> categoryBox;
    @javafx.fxml.FXML
    private TextArea StrategyInfoField;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy,String> strategyNameCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy,String> priorityCol;
    @javafx.fxml.FXML
    private DatePicker implementationDatePicker;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy,String> categoryCol;
    @javafx.fxml.FXML
    private CheckBox highPriorityCheckbox;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy,String> strategyDescriptionCol;
    @javafx.fxml.FXML
    private ComboBox<String> priorityLevelComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        strategyNameCol.setCellValueFactory(new PropertyValueFactory<InvestmentStrategy,String>("strategyName"));
        strategyDescriptionCol.setCellValueFactory(new PropertyValueFactory<InvestmentStrategy,String>("strategyDescription"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<InvestmentStrategy,String>("category"));
        dateCol.setCellValueFactory(new PropertyValueFactory<InvestmentStrategy,LocalDate>("implementationDate"));
        priorityCol.setCellValueFactory(new PropertyValueFactory<InvestmentStrategy,String>("priority"));
        highPriorityCol.setCellValueFactory(new PropertyValueFactory<InvestmentStrategy,String>("highPriority"));
        categoryBox.getItems().addAll("Foreign Investment","Local Investment","Joint Ventures");
        priorityLevelComboBox.getItems().addAll("High","Medium","Low");
    }

    @javafx.fxml.FXML
    public void showAllStrategiesOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal1b_recordinvestmentstrategies.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void addStrategyOnActionButton(ActionEvent actionEvent) {
        String strategyName = strategyNameField.getText();
        String strategyDescription = StrategyInfoField.getText();
        String category = categoryBox.getValue();
        LocalDate implementationDate = implementationDatePicker.getValue();
        String priority = priorityLevelComboBox.getValue();
        String str="";
        if(highPriorityCheckbox.isSelected()){
            str="Checked";
        }else {
            str="Unchecked";
        }

        if(strategyName.isEmpty() || strategyDescription.isEmpty() || category==null || implementationDate== null){
            showAlert("Validation Error","All fields are required");
            return;

        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("investmentstrategies.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            //public InvestmentStrategy(String strategyName, String strategyDescription, String category, LocalDate implementationDate, String priority, String highPriority)
            InvestmentStrategy is=new InvestmentStrategy(strategyName,strategyDescription,category,implementationDate,priority,str);
            investmentStrategyTable.getItems().add(is);
            oos.writeObject(is);
            strategyNameField.clear();
            StrategyInfoField.clear();
            categoryBox.setValue(null);
            implementationDatePicker.setValue(null);
            priorityLevelComboBox.setValue(null);
            highPriorityCheckbox.setSelected(true);

        }catch(IOException ex){
            Logger.getLogger(Goal1RecordinvestmentstrategiesController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal1RecordinvestmentstrategiesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/doIDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}