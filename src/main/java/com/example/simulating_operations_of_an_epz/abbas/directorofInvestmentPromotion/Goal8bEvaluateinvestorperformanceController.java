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

public class Goal8bEvaluateinvestorperformanceController
{
    @javafx.fxml.FXML
    private TableColumn<InvestorPerformance,String> nameCo;
    @javafx.fxml.FXML
    private TableColumn<InvestorPerformance,Double> ammountCo;
    @javafx.fxml.FXML
    private TableView<InvestorPerformance> evaluateTable;
    @javafx.fxml.FXML
    private TableColumn<InvestorPerformance,String> aTitleCo;
    @javafx.fxml.FXML
    private TableColumn<InvestorPerformance,String> performanceRatingCol;

    @javafx.fxml.FXML
    public void initialize() {
        aTitleCo.setCellValueFactory(new PropertyValueFactory<>("investmentTitle"));
        ammountCo.setCellValueFactory(new PropertyValueFactory<>("investmentAmount"));
        nameCo.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        performanceRatingCol.setCellValueFactory(new PropertyValueFactory<>("performanceRating"));
        viewEvaluatedProposals();
    }

    @javafx.fxml.FXML
    public void GoBackOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal8_evaluateinvestorperformance.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void deleteAEvaluaitonOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<InvestorPerformance> selectionModel = evaluateTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<InvestorPerformance> remainingEvaluationList = FXCollections.observableArrayList(evaluateTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingEvaluationList.remove(evaluateTable.getItems().get(index));
            evaluateTable.getItems().remove(index);

        }
        updateEvaluatedFile(remainingEvaluationList,"approvedinvestorperformance.bin");
    }

    public void viewEvaluatedProposals(){
        ObjectInputStream ois = null;
        try {
            InvestorPerformance a;
            ois = new ObjectInputStream(new FileInputStream("approvedinvestorperformance.bin"));
            while (true){
                a= (InvestorPerformance) ois.readObject();
                evaluateTable.getItems().add(a);

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

    private void updateEvaluatedFile(ObservableList<InvestorPerformance> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(InvestorPerformance investorPerformance:data) {
                oos.writeObject(investorPerformance);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}