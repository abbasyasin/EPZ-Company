package com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssetprotectionController {

    @FXML
    private TextField assetIdTextField;

    @FXML
    private ComboBox<String> assetTypeCombobox;

    @FXML
    private TextField locationTextfield;
    @FXML
    private TableColumn<AssetProtection,Integer> assetIdColumn;
    @FXML
    private TableColumn<AssetProtection,String> locationColumn;
    @FXML
    private TableColumn<AssetProtection,String> assetTypeColumn;
    @FXML
    private TableView<AssetProtection> tableView;
    @FXML
    private TableColumn<AssetProtection,String> securityStatusColumn;
    @FXML
    private ComboBox<String> securityCombobox;

    @FXML
    public void initialize() {
        assetTypeCombobox.getItems().addAll(" Equipment","Documents","Vehicles","Chair","Computer","CCTV Camera");
        securityCombobox.getItems().addAll("Secured", "At Risk","Expire");
        assetIdColumn.setCellValueFactory(new PropertyValueFactory<AssetProtection,Integer>("assetId"));
        securityStatusColumn.setCellValueFactory(new PropertyValueFactory<AssetProtection,String>("secureStatus"));
        assetTypeColumn.setCellValueFactory(new PropertyValueFactory<AssetProtection,String>("assetType"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<AssetProtection,String>("location"));
        loadAssetProtection();
    }
    @FXML
    void addButton(ActionEvent event) {
        tableView.getItems().clear();
        int assetId;
        if (assetIdTextField.getText().isEmpty()){
            return;
        }else{
            assetId=Integer.parseInt(assetIdTextField.getText());
        }
        String assetType=assetTypeCombobox.getValue();
        if (assetType==null){
            return;
        }
        String location=locationTextfield.getText();
        if (location==null){
            return;
        }
        String securityStatus=securityCombobox.getValue();
        if (securityStatus==null){
            return;
        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("AssetProtection.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            AssetProtection y=new AssetProtection(assetId,assetType,location,securityStatus);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(AssetprotectionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(AssetprotectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        assetIdTextField.clear();
        assetTypeCombobox.setValue(null);
        locationTextfield.clear();
        securityCombobox.setValue(null);



    }
    @FXML
    void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/csODashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    public void showAllButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        loadAssetProtection();
    }
    public void loadAssetProtection(){
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
