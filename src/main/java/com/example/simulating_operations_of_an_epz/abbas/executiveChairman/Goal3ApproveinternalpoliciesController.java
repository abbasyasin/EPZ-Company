package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

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

public class Goal3ApproveinternalpoliciesController
{
    @javafx.fxml.FXML
    private TextField policyNameTextField;
    @javafx.fxml.FXML
    private TextArea DescriptionTextArea;
    @javafx.fxml.FXML
    private TableColumn<Policy,LocalDate> effectiveDateCol;
    @javafx.fxml.FXML
    private TableColumn<Policy,String> policyNameCol;
    @javafx.fxml.FXML
    private TableView<Policy> policiesTable;
    @javafx.fxml.FXML
    private DatePicker effectiveDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Policy,String> descriptionCol;

    @javafx.fxml.FXML
    public void initialize() {
        policyNameCol.setCellValueFactory(new PropertyValueFactory<>("policyName"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        effectiveDateCol.setCellValueFactory(new PropertyValueFactory<>("effectiveDate"));
    }

    @javafx.fxml.FXML
    public void showAllPolicesOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal3b_approveinternalpolicies.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void approvePolicyOnActionButton(ActionEvent actionEvent) {
        String policyName = policyNameTextField.getText();
        String description = DescriptionTextArea.getText();
        LocalDate effectiveDate = effectiveDateDatePicker.getValue();
        if(policyName.isEmpty() || description.isEmpty() || effectiveDate==null) {
            showAlert("Validation Error","All fields are required");
            return;
        }
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("approvedpolicies.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Policy p=new Policy(policyName,description,effectiveDate);
            policiesTable.getItems().add(p);
            oos.writeObject(p);
            policyNameTextField.clear();
            DescriptionTextArea.clear();
            effectiveDateDatePicker.setValue(null);


        }catch(IOException ex){
            Logger.getLogger(Goal3ApproveinternalpoliciesController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal3ApproveinternalpoliciesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}