package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

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

public class Goal7bReviewincedentreportsController
{
    @javafx.fxml.FXML
    private TableColumn<RemarksOfIncidentReport,Integer> remarksICol;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfIncidentReport,String> remarksTypCol;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfIncidentReport,LocalDate> remarksdatCol;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfIncidentReport,String> remarksReportedBCol;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfIncidentReport,String> remarkdescriptioCol;
    @javafx.fxml.FXML
    private TableView<RemarksOfIncidentReport> remarkTable;

    @javafx.fxml.FXML
    public void initialize() {
        remarksICol.setCellValueFactory(new PropertyValueFactory<>("incidentId"));
        remarksTypCol.setCellValueFactory(new PropertyValueFactory<>("incidentType"));
        remarksdatCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        remarksReportedBCol.setCellValueFactory(new PropertyValueFactory<>("reportedBy"));
        remarkdescriptioCol.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        loadRemarksIncidentReport();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal7_reviewincedentreports.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void deleteAIncedentReviewOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<RemarksOfIncidentReport> selectionModel = remarkTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<RemarksOfIncidentReport> remainingIncedentRemarks= FXCollections.observableArrayList(remarkTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingIncedentRemarks.remove(remarkTable.getItems().get(index));
            remarkTable.getItems().remove(index);

        }
        updateIncedentRemarkFile(remainingIncedentRemarks,"remarksincedentreport.bin");
    }

    private void loadRemarksIncidentReport(){
        ObjectInputStream ois = null;
        try {
            RemarksOfIncidentReport r;
            ois = new ObjectInputStream(new FileInputStream("remarksincedentreport.bin"));
            while (true){
                r= (RemarksOfIncidentReport) ois.readObject();
                remarkTable.getItems().add(r);
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

    private void updateIncedentRemarkFile(ObservableList<RemarksOfIncidentReport> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(RemarksOfIncidentReport remarksOfIncidentReport:data) {
                oos.writeObject(remarksOfIncidentReport);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}