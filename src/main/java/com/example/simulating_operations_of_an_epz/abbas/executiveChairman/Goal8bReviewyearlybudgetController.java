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

public class Goal8bReviewyearlybudgetController
{
    @javafx.fxml.FXML
    private TableColumn<RemarksOfYearlyReport,String> budgetRemarkCategoryCo;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfYearlyReport,Double> budgetRemarkAmmountCo;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfYearlyReport,LocalDate> budgetRemarkYearCo;
    @javafx.fxml.FXML
    private TableView<RemarksOfYearlyReport> budgetRemarkTabl;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfYearlyReport,String> budgetRemarksDescriptionCo;
    @javafx.fxml.FXML
    private TableColumn<RemarksOfYearlyReport,Double> budgetRemarkPercentageCo;

    @javafx.fxml.FXML
    public void initialize() {
        budgetRemarkCategoryCo.setCellValueFactory(new PropertyValueFactory<>("category"));
        budgetRemarkPercentageCo.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        budgetRemarkAmmountCo.setCellValueFactory(new PropertyValueFactory<>("amount"));
        budgetRemarkYearCo.setCellValueFactory(new PropertyValueFactory<>("year"));
        budgetRemarksDescriptionCo.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        loadRemarkedYearlyBudgets();
    }

    @javafx.fxml.FXML
    public void deleteAYearlyRemarkOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<RemarksOfYearlyReport> selectionModel = budgetRemarkTabl.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<RemarksOfYearlyReport> remainingYearlyBudgetRemarks= FXCollections.observableArrayList(budgetRemarkTabl.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingYearlyBudgetRemarks.remove(budgetRemarkTabl.getItems().get(index));
            budgetRemarkTabl.getItems().remove(index);

        }
        updateYearlyBudgetRemarkFile(remainingYearlyBudgetRemarks,"remarksyearlybudget.bin");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal8_reviewyearlybudget.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    private void loadRemarkedYearlyBudgets(){
        ObjectInputStream ois = null;
        try {
            RemarksOfYearlyReport v;
            ois = new ObjectInputStream(new FileInputStream("remarksyearlybudget.bin"));
            while (true){
                v= (RemarksOfYearlyReport) ois.readObject();
                budgetRemarkTabl.getItems().add(v);
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

    private void updateYearlyBudgetRemarkFile(ObservableList<RemarksOfYearlyReport> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(RemarksOfYearlyReport remarksOfYearlyReport:data) {
                oos.writeObject(remarksOfYearlyReport);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}