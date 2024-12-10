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
import java.util.Arrays;
import java.util.Objects;

public class Goal5bRecordmarkettrendsController
{
    @javafx.fxml.FXML
    private TableColumn<MarketTrend,String> impactLeveCol;
    @javafx.fxml.FXML
    private TableColumn<MarketTrend,String> affectedsectoCol;
    @javafx.fxml.FXML
    private TableView<MarketTrend> trenTable;
    @javafx.fxml.FXML
    private TableColumn<MarketTrend,String> trendDescriptioCol;
    @javafx.fxml.FXML
    private TableColumn<MarketTrend,String> trendNamCol;

    @javafx.fxml.FXML
    public void initialize() {
        trendNamCol.setCellValueFactory(new PropertyValueFactory<>("trendName"));
        affectedsectoCol.setCellValueFactory(new PropertyValueFactory<>("affectedSector"));
        impactLeveCol.setCellValueFactory(new PropertyValueFactory<>("impactLevel"));
        trendDescriptioCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        loadTrends();
    }

    @javafx.fxml.FXML
    public void deleteTrendActionBUtton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<MarketTrend> selectionModel = trenTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<MarketTrend> remainingTrend = FXCollections.observableArrayList(trenTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingTrend.remove(trenTable.getItems().get(index));
            trenTable.getItems().remove(index);

        }
        updateTrendFile(remainingTrend,"marketingtrends.bin");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal5_recordmarkettrends.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    private void loadTrends(){
        ObjectInputStream ois = null;
        try {
            MarketTrend m;
            ois = new ObjectInputStream(new FileInputStream("marketingtrends.bin"));
            while (true){
                m= (MarketTrend) ois.readObject();
                trenTable.getItems().add(m);
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

    private void updateTrendFile(ObservableList<MarketTrend> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(MarketTrend marketTrend:data) {
                oos.writeObject(marketTrend);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}