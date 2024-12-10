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

public class Goal6bOrganizenetworkingeventsforinvesotrsController
{
    @javafx.fxml.FXML
    private TableColumn<NetworkingEvent,String> netEventNamCol;
    @javafx.fxml.FXML
    private TableColumn<NetworkingEvent,String> netVenuCol;
    @javafx.fxml.FXML
    private TableColumn<NetworkingEvent,String> netDescriptioCol;
    @javafx.fxml.FXML
    private TableColumn<NetworkingEvent,LocalDate> netEventDatCol;
    @javafx.fxml.FXML
    private TableColumn<NetworkingEvent,Integer> netParticipantCol;
    @javafx.fxml.FXML
    private TableView<NetworkingEvent> netEvenTable;

    @javafx.fxml.FXML
    public void initialize() {
        netEventNamCol.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        netEventDatCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        netVenuCol.setCellValueFactory(new PropertyValueFactory<>("venue"));
        netParticipantCol.setCellValueFactory(new PropertyValueFactory<>("expectedParticipants"));
        netDescriptioCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        loadNetworkingEvents();
    }

    @javafx.fxml.FXML
    public void goBackOnActionbutton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal6_organizenetworkingeventsforinvesotrs.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void deleteANetworkingEventOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<NetworkingEvent> selectionModel = netEvenTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<NetworkingEvent> remainingNetEvents = FXCollections.observableArrayList(netEvenTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingNetEvents.remove(netEvenTable.getItems().get(index));
            netEvenTable.getItems().remove(index);

        }
        updateNetEventFile(remainingNetEvents,"networkingevents.bin");
    }

    private void loadNetworkingEvents(){
        ObjectInputStream ois = null;
        try {
            NetworkingEvent n;
            ois = new ObjectInputStream(new FileInputStream("networkingevents.bin"));
            while (true){
                n= (NetworkingEvent) ois.readObject();
                netEvenTable.getItems().add(n);
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

    private void updateNetEventFile(ObservableList<NetworkingEvent> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(NetworkingEvent networkingEvent:data) {
                oos.writeObject(networkingEvent);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}