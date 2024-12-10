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

public class Goal4bCreateinvestoreventplanController
{
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,String> evntNamCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,String> evntTypCol;
    @javafx.fxml.FXML
    private TableView<InvestmentEvent> eventPlaTable;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,String> evntDecriptiCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,String> evntpubliCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,String> evntLoCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,Double> evntBudgCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentEvent,LocalDate> evntDatCol;

    @javafx.fxml.FXML
    public void initialize() {
        evntNamCol.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        evntLoCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        evntBudgCol.setCellValueFactory(new PropertyValueFactory<>("budget"));
        evntTypCol.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        evntDecriptiCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        evntDatCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        evntpubliCol.setCellValueFactory(new PropertyValueFactory<>("isPublic"));
        loadEvents();
    }

    @javafx.fxml.FXML
    public void deleteEventOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<InvestmentEvent> selectionModel = eventPlaTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<InvestmentEvent> remainingEvents = FXCollections.observableArrayList(eventPlaTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingEvents.remove(eventPlaTable.getItems().get(index));
            eventPlaTable.getItems().remove(index);

        }
        updateEventFile(remainingEvents,"investmentevents.bin");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal4_createinvestoreventplan.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    private void loadEvents(){
        ObjectInputStream ois = null;
        try {
            InvestmentEvent l;
            ois = new ObjectInputStream(new FileInputStream("investmentevents.bin"));
            while (true){
                l= (InvestmentEvent) ois.readObject();
                eventPlaTable.getItems().add(l);
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

    private void updateEventFile(ObservableList<InvestmentEvent> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(InvestmentEvent investmentEvent:data) {
                oos.writeObject(investmentEvent);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}