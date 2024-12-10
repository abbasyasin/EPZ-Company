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

public class Goal3bApproveinternalpoliciesController
{
    @javafx.fxml.FXML
    private TableColumn<Policy, LocalDate> effectiveDateCol;
    @javafx.fxml.FXML
    private TableColumn<Policy,String> policyNameCol;
    @javafx.fxml.FXML
    private TableView<Policy> policiesTable;
    @javafx.fxml.FXML
    private TableColumn<Policy,String> descriptionCol;

    @javafx.fxml.FXML
    public void initialize() {
        policyNameCol.setCellValueFactory(new PropertyValueFactory<>("policyName"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        effectiveDateCol.setCellValueFactory(new PropertyValueFactory<>("effectiveDate"));
        loadPolicies();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal3_approveinternalpolicies.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void updatePolicyOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<Policy> selectionModel = policiesTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<Policy> remainingpolicies= FXCollections.observableArrayList(policiesTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingpolicies.remove(policiesTable.getItems().get(index));
            policiesTable.getItems().remove(index);

        }
        updatePolicyFile(remainingpolicies,"approvedpolicies.bin");
    }
    private void loadPolicies(){
        ObjectInputStream ois = null;
        try {
            Policy p;
            ois = new ObjectInputStream(new FileInputStream("approvedpolicies.bin"));
            while (true){
                p= (Policy) ois.readObject();
                policiesTable.getItems().add(p);
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
    private void updatePolicyFile(ObservableList<Policy> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(Policy policy:data) {
                oos.writeObject(policy);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}