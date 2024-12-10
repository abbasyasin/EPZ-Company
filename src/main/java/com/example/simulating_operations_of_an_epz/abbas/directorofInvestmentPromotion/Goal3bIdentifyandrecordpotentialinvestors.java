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

public class Goal3bIdentifyandrecordpotentialinvestors
{
    @javafx.fxml.FXML
    private TableColumn<PotentialInvestor,String> contacCol;
    @javafx.fxml.FXML
    private TableColumn<PotentialInvestor,String> investorNamCol;
    @javafx.fxml.FXML
    private TableView<PotentialInvestor> potentialInvestoTable;
    @javafx.fxml.FXML
    private TableColumn<PotentialInvestor,String> orCol;
    @javafx.fxml.FXML
    private TableColumn<PotentialInvestor,String> investmentInterescol;

    @javafx.fxml.FXML
    public void initialize() {
        investorNamCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        orCol.setCellValueFactory(new PropertyValueFactory<>("organization"));
        investmentInterescol.setCellValueFactory(new PropertyValueFactory<>("investmentInterest"));
        contacCol.setCellValueFactory(new PropertyValueFactory<>("contactInfo"));
        loadPotentialInvestors();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal3_identifyandrecordpotentialinvestors.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void deletePotentialInvestorInfoOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<PotentialInvestor> selectionModel = potentialInvestoTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<PotentialInvestor> remainingInvestors = FXCollections.observableArrayList(potentialInvestoTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingInvestors.remove(potentialInvestoTable.getItems().get(index));
            potentialInvestoTable.getItems().remove(index);

        }
        updatePotentialInvestorFile(remainingInvestors,"potentialinvestors.bin");
    }

    private void loadPotentialInvestors(){
        ObjectInputStream ois = null;
        try {
            PotentialInvestor p;
            ois = new ObjectInputStream(new FileInputStream("potentialinvestors.bin"));
            while (true){
                p= (PotentialInvestor) ois.readObject();
                potentialInvestoTable.getItems().add(p);
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

    private void updatePotentialInvestorFile(ObservableList<PotentialInvestor> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(PotentialInvestor potentialInvestor:data) {
                oos.writeObject(potentialInvestor);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}