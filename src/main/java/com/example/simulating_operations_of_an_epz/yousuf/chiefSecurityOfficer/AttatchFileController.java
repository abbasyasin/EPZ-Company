package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

public class AttatchFileController
{
    @javafx.fxml.FXML
    private TableColumn<AssetProtection,String> locationColumn;
    @javafx.fxml.FXML
    private TableColumn<AssetProtection,String> assetTypeColumn;
    @javafx.fxml.FXML
    private TableView<AssetProtection> tableView;
    @javafx.fxml.FXML
    private TableColumn<AssetProtection,String> liveStatuscolumn;
    @FXML
    private TableColumn<AssetProtection,Integer> assetIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
        assetIdColumn.setCellValueFactory(new PropertyValueFactory<AssetProtection,Integer>("assetId"));
        liveStatuscolumn.setCellValueFactory(new PropertyValueFactory<AssetProtection,String>("secureStatus"));
        assetTypeColumn.setCellValueFactory(new PropertyValueFactory<AssetProtection,String>("assetType"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<AssetProtection,String>("location"));
        loadAssetProtectionData();
    }
    @javafx.fxml.FXML
    public void backToSurvilance(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/surveillanceMonitoring.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Visitor Management");
        window.setScene(scene2);
        window.show();
    }
    public void loadAssetProtectionData(){
        ObjectInputStream ois = null;
        try {
            AssetProtection y;
            ois = new ObjectInputStream(new FileInputStream("AssetProtection.bin"));
            while (true){
                y= (AssetProtection) ois.readObject();
                tableView.getItems().add(y);
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