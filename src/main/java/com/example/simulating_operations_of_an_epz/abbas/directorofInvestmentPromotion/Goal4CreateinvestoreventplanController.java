package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
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

public class Goal4CreateinvestoreventplanController
{
    @javafx.fxml.FXML
    private ComboBox<String> eventtypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,String> evntNameCol;
    @javafx.fxml.FXML
    private CheckBox openForPublicCheckbox;
    @javafx.fxml.FXML
    private TableView<InvestmentEvent> eventPlanTable;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,String> evntLocCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,Double> evntBudgtCol;
    @javafx.fxml.FXML
    private TextField evntBudgetTextField;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,String> evntTypeCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,String> evntDecriptinCol;
    @javafx.fxml.FXML
    private TextField evntNameTextField;
    @javafx.fxml.FXML
    private TextField evntLocationTextField;
    @javafx.fxml.FXML
    private TextArea evntDescriptionTextField;
    @javafx.fxml.FXML
    private DatePicker evntdateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,String> evntpublicCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,LocalDate> evntDateCol;

    @javafx.fxml.FXML
    public void initialize() {
        evntNameCol.setCellValueFactory(new PropertyValueFactory<InvestmentEvent,String>("eventName"));
        evntLocCol.setCellValueFactory(new PropertyValueFactory<InvestmentEvent,String>("location"));
        evntBudgtCol.setCellValueFactory(new PropertyValueFactory<InvestmentEvent,Double>("budget"));
        evntTypeCol.setCellValueFactory(new PropertyValueFactory<InvestmentEvent,String>("eventType"));
        evntDecriptinCol.setCellValueFactory(new PropertyValueFactory<InvestmentEvent,String>("description"));
        evntDateCol.setCellValueFactory(new PropertyValueFactory<InvestmentEvent,LocalDate>("date"));
        evntpublicCol.setCellValueFactory(new PropertyValueFactory<InvestmentEvent,String>("isPublic"));
        eventtypeComboBox.getItems().addAll("Conference","Workshop","Expo","Seminar");
    }

    @javafx.fxml.FXML
    public void addEventPlanOnActionbutton(ActionEvent actionEvent) {
        String eventName=evntNameTextField.getText();
        LocalDate date=evntdateDatePicker.getValue();
        String location=evntLocationTextField.getText();
        String budgetText=evntBudgetTextField.getText();
        String descriptionText=evntDescriptionTextField.getText();
        String eventType=eventtypeComboBox.getValue();
        String s="";
        if(openForPublicCheckbox.isSelected()){
            s="YES";
        }else{
            s="NO";
        }

        if(eventName.isEmpty() || date == null || location.isEmpty() || budgetText.isEmpty() || descriptionText.isEmpty() || eventType==null){
            showAlert("Validation Error","All fields are required");
            return;
        }
        double budget;
        try{
            budget=Double.parseDouble(budgetText);
        } catch (NumberFormatException e) {
            showAlert("Validation Error","budget must be numeric");
            return;
        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("investmentevents.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            InvestmentEvent i=new InvestmentEvent(eventName,date,location,budget,descriptionText,eventType,s);
            eventPlanTable.getItems().add(i);
            oos.writeObject(i);
            evntNameTextField.clear();
            evntLocationTextField.clear();
            evntBudgetTextField.clear();
            evntDescriptionTextField.clear();
            eventtypeComboBox.setValue(null);
            openForPublicCheckbox.setSelected(false);
            evntdateDatePicker.setValue(null);


        }catch(IOException ex){
            Logger.getLogger(Goal4CreateinvestoreventplanController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal4CreateinvestoreventplanController.class.getName()).log(Level.SEVERE, null, ex);
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

    @javafx.fxml.FXML
    public void showAllEventsOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal4b_createinvestoreventplan.fxml")));
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