package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Goal2bTrackandviewmarketingcampaignsController
{
    @javafx.fxml.FXML
    private TableView<MarketingCampaign> campaignTable;
    @javafx.fxml.FXML
    private TableColumn<MarketingCampaign,String> targetAudiencCol;
    @javafx.fxml.FXML
    private TableColumn<MarketingCampaign, LocalDate> encol;
    @javafx.fxml.FXML
    private TableColumn<MarketingCampaign,LocalDate> strcol;
    @javafx.fxml.FXML
    private TableColumn<MarketingCampaign,String> campaignNamCol;
    @javafx.fxml.FXML
    private TableColumn<MarketingCampaign,Double> budgeColumn;

    @javafx.fxml.FXML
    public void initialize() {
        campaignNamCol.setCellValueFactory(new PropertyValueFactory<>("campaignName"));
        targetAudiencCol.setCellValueFactory(new PropertyValueFactory<>("targetAudience"));
        budgeColumn.setCellValueFactory(new PropertyValueFactory<>("budget"));
        strcol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        encol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        loadCampaigns();
    }

    @javafx.fxml.FXML
    public void goBackActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal2_trackandviewmarketingcampaigns.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void deleteCampaginActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<MarketingCampaign> selectionModel = campaignTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<MarketingCampaign> remainingCampaigns = FXCollections.observableArrayList(campaignTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingCampaigns.remove(campaignTable.getItems().get(index));
            campaignTable.getItems().remove(index);

        }
        updateCampaignFile(remainingCampaigns,"marketingcampaigns.bin");

    }

    private void loadCampaigns() {
        ObjectInputStream ois = null;
        try {
            MarketingCampaign m;
            ois = new ObjectInputStream(new FileInputStream("marketingcampaigns.bin"));
            while (true) {
                m = (MarketingCampaign) ois.readObject();
                campaignTable.getItems().add(m);
            }
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

    private void updateCampaignFile(ObservableList<MarketingCampaign> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(MarketingCampaign marketingCampaign:data) {
                oos.writeObject(marketingCampaign);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}