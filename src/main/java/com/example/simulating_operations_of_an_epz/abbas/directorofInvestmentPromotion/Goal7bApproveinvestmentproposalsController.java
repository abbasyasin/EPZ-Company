package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Goal7bApproveinvestmentproposalsController
{
    @javafx.fxml.FXML
    private TableColumn<ApproveInvestmentProposals,String> approvalCol;
    @javafx.fxml.FXML
    private TableColumn<ApproveInvestmentProposals,Double> ammountCol;
    @javafx.fxml.FXML
    private TableColumn<ApproveInvestmentProposals,String> docCol;
    @javafx.fxml.FXML
    private TableView<ApproveInvestmentProposals> approvalTable;
    @javafx.fxml.FXML
    private TableColumn<ApproveInvestmentProposals,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<ApproveInvestmentProposals,String> aTitleCol;
    @javafx.fxml.FXML
    private Button deleteAllProposalButton;
    @javafx.fxml.FXML
    private Button deleteApprovedProposalButton;
    @javafx.fxml.FXML
    private Button deleteRejectedProposalButton;
    @javafx.fxml.FXML
    private Button showAprrovedProposalButton;
    @javafx.fxml.FXML
    private Button showAllProposalButton;
    @javafx.fxml.FXML
    private Button showRejectedProposalButton;

    @javafx.fxml.FXML
    public void initialize() {
        aTitleCol.setCellValueFactory(new PropertyValueFactory<>("investmentTitle"));
        ammountCol.setCellValueFactory(new PropertyValueFactory<>("investmentAmount"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        docCol.setCellValueFactory(new PropertyValueFactory<>("documents"));
        approvalCol.setCellValueFactory(new PropertyValueFactory<>("approveInvestmentProposal"));
        viewAllProposals();
        deleteApprovedProposalButton.setVisible(false);
        deleteRejectedProposalButton.setVisible(false);
        deleteAllProposalButton.setVisible(false);
    }

    @javafx.fxml.FXML
    public void showAllProposalsOnActionButton(ActionEvent actionEvent) {
        deleteAllProposalButton.setVisible(true);
        deleteApprovedProposalButton.setVisible(false);
        deleteRejectedProposalButton.setVisible(false);
        approvalTable.getItems().clear();
        viewAllProposals();
    }

    @javafx.fxml.FXML
    public void showRejectedProposalsOnActionButton(ActionEvent actionEvent) {
        deleteRejectedProposalButton.setVisible(true);
        deleteApprovedProposalButton.setVisible(false);
        deleteAllProposalButton.setVisible(false);
        approvalTable.getItems().clear();
        viewRejectedProposals();
    }

    @javafx.fxml.FXML
    public void showAprrovedProposalsOnActionButton(ActionEvent actionEvent) {
        deleteApprovedProposalButton.setVisible(true);
        deleteRejectedProposalButton.setVisible(false);
        deleteAllProposalButton.setVisible(false);
        approvalTable.getItems().clear();
        viewApprovedProposals();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal7_approveinvestmentproposals.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    public void viewApprovedProposals(){
        ObjectInputStream ois = null;
        try {
            ApproveInvestmentProposals a;
            ois = new ObjectInputStream(new FileInputStream("approvedinvestmentproposals.bin"));
            while (true){
                a= (ApproveInvestmentProposals) ois.readObject();
                approvalTable.getItems().add(a);
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

    public void viewRejectedProposals(){
        ObjectInputStream ois = null;
        try {
            ApproveInvestmentProposals a;
            ois = new ObjectInputStream(new FileInputStream("rejectedinvestmentproposals.bin"));
            while (true){
                a= (ApproveInvestmentProposals) ois.readObject();
                approvalTable.getItems().add(a);
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

    public void viewAllProposals(){
        ObjectInputStream ois = null;
        try {
            ApproveInvestmentProposals a;
            ois = new ObjectInputStream(new FileInputStream("allinvestmentproposals.bin"));
            while (true){
                a= (ApproveInvestmentProposals) ois.readObject();
                approvalTable.getItems().add(a);
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

    @javafx.fxml.FXML
    public void deleteAAllProposalOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<ApproveInvestmentProposals> selectionModel = approvalTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<ApproveInvestmentProposals> remainingAllProposalList = FXCollections.observableArrayList(approvalTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingAllProposalList.remove(approvalTable.getItems().get(index));
            approvalTable.getItems().remove(index);

        }
        updateAllProposalFile(remainingAllProposalList,"allinvestmentproposals.bin");
    }

    @javafx.fxml.FXML
    public void deleteAApprovedProposalOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<ApproveInvestmentProposals> selectionModel = approvalTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<ApproveInvestmentProposals> remainingApprovedList = FXCollections.observableArrayList(approvalTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingApprovedList.remove(approvalTable.getItems().get(index));
            approvalTable.getItems().remove(index);

        }
        updateApprovedFile(remainingApprovedList,"approvedinvestmentproposals.bin");
    }

    @javafx.fxml.FXML
    public void deleteARejectedProposalOnActionButton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<ApproveInvestmentProposals> selectionModel = approvalTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<ApproveInvestmentProposals> remainingRejectedList = FXCollections.observableArrayList(approvalTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingRejectedList.remove(approvalTable.getItems().get(index));
            approvalTable.getItems().remove(index);

        }
        updateRejectedFile(remainingRejectedList,"rejectedinvestmentproposals.bin");
    }

    private void updateApprovedFile(ObservableList<ApproveInvestmentProposals> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(ApproveInvestmentProposals approveInvestmentProposals:data) {
                oos.writeObject(approveInvestmentProposals);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void updateRejectedFile(ObservableList<ApproveInvestmentProposals> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(ApproveInvestmentProposals approveInvestmentProposals:data) {
                oos.writeObject(approveInvestmentProposals);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void updateAllProposalFile(ObservableList<ApproveInvestmentProposals> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(ApproveInvestmentProposals approveInvestmentProposals:data) {
                oos.writeObject(approveInvestmentProposals);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}