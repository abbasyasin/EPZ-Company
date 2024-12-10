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
import java.util.Arrays;
import java.util.Objects;

public class Goal6bSetLongtermVisionStatement
{
    @javafx.fxml.FXML
    private TableView<VisionStatement> visionTable;
    @javafx.fxml.FXML
    private TableColumn<VisionStatement,Integer> targetYerCol;
    @javafx.fxml.FXML
    private TableColumn<VisionStatement,String> statemntCol;

    @javafx.fxml.FXML
    public void initialize() {
        targetYerCol.setCellValueFactory(new PropertyValueFactory<>("targetYear"));
        statemntCol.setCellValueFactory(new PropertyValueFactory<>("statement"));
        loadStaments();
    }

    @javafx.fxml.FXML
    public void deleteStatementOnactionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<VisionStatement> selectionModel = visionTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<VisionStatement> remainingstatements= FXCollections.observableArrayList(visionTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingstatements.remove(visionTable.getItems().get(index));
            visionTable.getItems().remove(index);

        }
        updateStatementFile(remainingstatements,"visionstatements.bin");
    }

    @javafx.fxml.FXML
    public void goBackAction(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal6_setLongtermVisionStatement.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    private void loadStaments(){
        ObjectInputStream ois = null;
        try {
            VisionStatement v;
            ois = new ObjectInputStream(new FileInputStream("visionstatements.bin"));
            while (true){
                v= (VisionStatement) ois.readObject();
                visionTable.getItems().add(v);
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

    private void updateStatementFile(ObservableList<VisionStatement> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(VisionStatement visionStatement:data) {
                oos.writeObject(visionStatement);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}