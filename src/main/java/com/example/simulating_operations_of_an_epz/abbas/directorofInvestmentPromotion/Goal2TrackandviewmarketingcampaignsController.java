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

public class Goal2TrackandviewmarketingcampaignsController
{
    @javafx.fxml.FXML
    private TextField budgetField;
    @javafx.fxml.FXML
    private TableColumn<MarketingCampaign,LocalDate> endcol;
    @javafx.fxml.FXML
    private TableColumn<MarketingCampaign,String> campaignNameCol;
    @javafx.fxml.FXML
    private DatePicker startdp;
    @javafx.fxml.FXML
    private DatePicker enddp;
    @javafx.fxml.FXML
    private TableView<MarketingCampaign> campaginTable;
    @javafx.fxml.FXML
    private TableColumn<MarketingCampaign,Double> budgetColumn;
    @javafx.fxml.FXML
    private TableColumn<MarketingCampaign,LocalDate> strtcol;
    @javafx.fxml.FXML
    private TextField campaignNameField;
    @javafx.fxml.FXML
    private TextField targetAudienceField;
    @javafx.fxml.FXML
    private TableColumn<MarketingCampaign,String> targetAudienceCol;

    @javafx.fxml.FXML
    public void initialize() {
        campaignNameCol.setCellValueFactory(new PropertyValueFactory<MarketingCampaign,String>("campaignName"));
        targetAudienceCol.setCellValueFactory(new PropertyValueFactory<MarketingCampaign,String>("targetAudience"));
        budgetColumn.setCellValueFactory(new PropertyValueFactory<MarketingCampaign,Double>("budget"));
        strtcol.setCellValueFactory(new PropertyValueFactory<MarketingCampaign,LocalDate>("startDate"));
        endcol.setCellValueFactory(new PropertyValueFactory<MarketingCampaign,LocalDate>("endDate"));
    }

    @javafx.fxml.FXML
    public void loadAllCampaignsOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal2b_trackandviewmarketingcampaigns.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void addCampaignOnActionbutton(ActionEvent actionEvent) {
        String campaignName = campaignNameField.getText();
        String targetAudience = targetAudienceField.getText();
        String budgetText = budgetField.getText();
        LocalDate startDate = startdp.getValue();
        LocalDate endDate = enddp.getValue();

        if(campaignName.isEmpty() || targetAudience.isEmpty() || budgetText.isEmpty() || startDate==null || endDate==null) {
            showAlert("Validation Error","All fields are required");
            return;

        }
        double budget;
        try {
            budget = Double.parseDouble(budgetText);

        } catch (NumberFormatException e) {
            showAlert("Validation Error","budget should be a number");
            return;
        }
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("marketingcampaigns.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            MarketingCampaign campaign=new MarketingCampaign(campaignName,targetAudience,budget,startDate,endDate);
            campaginTable.getItems().add(campaign);
            oos.writeObject(campaign);
            campaignNameField.clear();
            targetAudienceField.clear();
            budgetField.clear();
            startdp.setValue(null);
            enddp.setValue(null);

        }catch(IOException ex){
            Logger.getLogger(Goal2TrackandviewmarketingcampaignsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal2TrackandviewmarketingcampaignsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}