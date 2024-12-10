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
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Goal1bLoadstrategicgoalsController
{
    @javafx.fxml.FXML
    private TableColumn<StrategicGoal,String> titlecol;
    @javafx.fxml.FXML
    private TableColumn<StrategicGoal, LocalDate> deadlinecol;
    @javafx.fxml.FXML
    private TableView<StrategicGoal> goalsTable;
    @javafx.fxml.FXML
    private TableColumn<StrategicGoal,String> prioritycol;
    @javafx.fxml.FXML
    private TableColumn<StrategicGoal,String> categorycol;
    @javafx.fxml.FXML
    private TableColumn<StrategicGoal,String> descriptioncol;

    @javafx.fxml.FXML
    public void initialize() {
        titlecol.setCellValueFactory(new PropertyValueFactory<>("title"));
        categorycol.setCellValueFactory(new PropertyValueFactory<>("category"));
        deadlinecol.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        prioritycol.setCellValueFactory(new PropertyValueFactory<>("priority"));
        descriptioncol.setCellValueFactory(new PropertyValueFactory<>("description"));
        loadGoals();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal1_strategicgoals.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void deleteDataOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<StrategicGoal> selectionModel = goalsTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<StrategicGoal> remaininggoals= FXCollections.observableArrayList(goalsTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remaininggoals.remove(goalsTable.getItems().get(index));
            goalsTable.getItems().remove(index);

        }
        updateGoalFile(remaininggoals,"strategicgoals.bin");

    }

    private void updateGoalFile(ObservableList<StrategicGoal> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(StrategicGoal goal:data) {
                oos.writeObject(goal);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void loadGoals(){
        ObjectInputStream ois = null;
        try {
            StrategicGoal s;
            ois = new ObjectInputStream(new FileInputStream("strategicgoals.bin"));
            while (true){
                s= (StrategicGoal) ois.readObject();
                goalsTable.getItems().add(s);
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