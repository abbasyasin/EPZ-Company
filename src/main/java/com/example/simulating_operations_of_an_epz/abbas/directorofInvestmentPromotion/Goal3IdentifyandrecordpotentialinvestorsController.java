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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Goal3IdentifyandrecordpotentialinvestorsController
{
    @javafx.fxml.FXML
    private TableColumn<PotentialInvestor,String> investmentInterestcol;
    @javafx.fxml.FXML
    private TextField ContactInfoField;
    @javafx.fxml.FXML
    private TableColumn<PotentialInvestor,String> contactCol;
    @javafx.fxml.FXML
    private TextField investorNameField;
    @javafx.fxml.FXML
    private TableColumn<PotentialInvestor,String> investorNameCol;
    @javafx.fxml.FXML
    private TableColumn<PotentialInvestor,String> orgCol;
    @javafx.fxml.FXML
    private TextField organizationField;
    @javafx.fxml.FXML
    private ComboBox<String> interestBox;
    @javafx.fxml.FXML
    private TableView<PotentialInvestor> potentialInvestorTable;

    @javafx.fxml.FXML
    public void initialize() {
        investorNameCol.setCellValueFactory(new PropertyValueFactory<PotentialInvestor,String>("name"));
        orgCol.setCellValueFactory(new PropertyValueFactory<PotentialInvestor,String>("organization"));
        investmentInterestcol.setCellValueFactory(new PropertyValueFactory<PotentialInvestor,String>("investmentInterest"));
        contactCol.setCellValueFactory(new PropertyValueFactory<PotentialInvestor,String>("contactInfo"));
        interestBox.getItems().addAll("Technology(Electronics Assembly)","Manufacturing(Garments And Apparel)","Manufacturing(Processed Food And Beverage Export)","Renewable Energy(Solar panel Manufacturing)");

    }

    @javafx.fxml.FXML
    public void showAllPotentialInvestorButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal3b_identifyandrecordpotentialinvestors.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/doIDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void AddPotentialInvestorActionButton(ActionEvent actionEvent) {
        String name=investorNameField.getText();
        String organization=organizationField.getText();
        String interest=interestBox.getValue();
        String contactInfo=ContactInfoField.getText();

        if(name.isEmpty() || organization.isEmpty() || interest.isEmpty() || contactInfo.isEmpty()){
            showAlert("Validation Error","All fields are required");
            return;

        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("potentialinvestors.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            PotentialInvestor p=new PotentialInvestor(name,organization,interest,contactInfo);

            potentialInvestorTable.getItems().add(p);
            oos.writeObject(p);
            investorNameField.clear();
            organizationField.clear();
            interestBox.setValue(null);
            ContactInfoField.clear();


        }catch(IOException ex){
            Logger.getLogger(Goal3IdentifyandrecordpotentialinvestorsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal3IdentifyandrecordpotentialinvestorsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}