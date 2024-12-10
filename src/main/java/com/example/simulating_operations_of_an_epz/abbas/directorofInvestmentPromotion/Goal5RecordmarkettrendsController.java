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

public class Goal5RecordmarkettrendsController
{
    @javafx.fxml.FXML
    private ComboBox<String> sectorComboBox;
    @javafx.fxml.FXML
    private TableColumn<MarketTrend,String> trendNameCol;
    @javafx.fxml.FXML
    private TextArea trendDescriptionTextField;
    @javafx.fxml.FXML
    private TableColumn<MarketTrend,String> impactLevelCol;
    @javafx.fxml.FXML
    private TextField trendNameTextField;
    @javafx.fxml.FXML
    private TableColumn<MarketTrend,String> trendDescriptionCol;
    @javafx.fxml.FXML
    private TableView<MarketTrend> trendTable;
    @javafx.fxml.FXML
    private TableColumn<MarketTrend,String> affectedsectorCol;
    @javafx.fxml.FXML
    private ComboBox<String> trendImpactComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        trendNameCol.setCellValueFactory(new PropertyValueFactory<MarketTrend,String>("trendName"));
        affectedsectorCol.setCellValueFactory(new PropertyValueFactory<MarketTrend,String>("affectedSector"));
        impactLevelCol.setCellValueFactory(new PropertyValueFactory<MarketTrend,String>("impactLevel"));
        trendDescriptionCol.setCellValueFactory(new PropertyValueFactory<MarketTrend,String>("description"));
        sectorComboBox.getItems().addAll("Technology","Manufacturing");
        trendImpactComboBox.getItems().addAll("High","Medium","Low");

    }

    @javafx.fxml.FXML
    public void addTrendOnActionButton(ActionEvent actionEvent) {
        String trendName = trendNameTextField.getText();
        String affectedSector = sectorComboBox.getValue();
        String impactLevel= trendImpactComboBox.getValue();
        String description = trendDescriptionTextField.getText();

        if(trendName.isEmpty() || affectedSector.isEmpty() || impactLevel.isEmpty() || description.isEmpty()) {
            showAlert("Validation Error","All fields are required");
            return;
        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("marketingtrends.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            MarketTrend m=new MarketTrend(trendName,affectedSector,impactLevel,description);
            trendTable.getItems().add(m);
            oos.writeObject(m);
            trendNameTextField.clear();
            trendDescriptionTextField.clear();
            trendImpactComboBox.setValue(null);
            sectorComboBox.setValue(null);

        }catch(IOException ex){
            Logger.getLogger(Goal5RecordmarkettrendsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal5RecordmarkettrendsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @javafx.fxml.FXML
    public void loadAlltrendsActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal5b_recordmarkettrends.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
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