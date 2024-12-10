package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.StrategicGoal;
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

public class Goal1bRecordinvestmentstrategiesController
{
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy,String> strategyNamCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy,String> categorCol;
    @javafx.fxml.FXML
    private TableView<InvestmentStrategy> investmentStrategyTable;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy,String> prioritCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy,String> highPrioritCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy, LocalDate> datCol;
    @javafx.fxml.FXML
    private TableColumn<InvestmentStrategy,String> strategyDescriptioCol;

    @javafx.fxml.FXML
    public void initialize() {
        strategyNamCol.setCellValueFactory(new PropertyValueFactory<>("strategyName"));
        strategyDescriptioCol.setCellValueFactory(new PropertyValueFactory<>("strategyDescription"));
        categorCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        datCol.setCellValueFactory(new PropertyValueFactory<>("implementationDate"));
        prioritCol.setCellValueFactory(new PropertyValueFactory<>("priority"));
        highPrioritCol.setCellValueFactory(new PropertyValueFactory<>("highPriority"));
        loadstrategies();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal1_recordinvestmentstrategies.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void deleteAStrategyOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<InvestmentStrategy> selectionModel = investmentStrategyTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<InvestmentStrategy> remainingStrateg = FXCollections.observableArrayList(investmentStrategyTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingStrateg.remove(investmentStrategyTable.getItems().get(index));
            investmentStrategyTable.getItems().remove(index);

        }

        updateStrategFile(remainingStrateg,"investmentstrategies.bin");

    }

    private void updateStrategFile(ObservableList<InvestmentStrategy> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(InvestmentStrategy strategy:data) {
                oos.writeObject(strategy);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void loadstrategies(){
        ObjectInputStream ois = null;
        try {
            InvestmentStrategy i;
            ois = new ObjectInputStream(new FileInputStream("investmentstrategies.bin"));
            while (true){
                i= (InvestmentStrategy) ois.readObject();
                investmentStrategyTable.getItems().add(i);
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