package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Goal8EvaluateinvestorperformanceController
{
    @javafx.fxml.FXML
    private ComboBox<String> performanceRatingComboBox;
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
    private TableColumn<InvestorPerformance,String> nameCo;
    @javafx.fxml.FXML
    private TableColumn<InvestorPerformance,Double> ammountCo;
    @javafx.fxml.FXML
    private TableColumn<ApproveInvestmentProposals,String> aTitleCol;
    @javafx.fxml.FXML
    private TableView<InvestorPerformance> evaluateTable;
    @javafx.fxml.FXML
    private TableColumn<InvestorPerformance,String> aTitleCo;
    @javafx.fxml.FXML
    private TableColumn<InvestorPerformance,String> performanceRatingCol;
    @javafx.fxml.FXML
    private ComboBox<String> investmentNameComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        aTitleCol.setCellValueFactory(new PropertyValueFactory<>("investmentTitle"));
        ammountCol.setCellValueFactory(new PropertyValueFactory<>("investmentAmount"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        docCol.setCellValueFactory(new PropertyValueFactory<>("documents"));
        approvalCol.setCellValueFactory(new PropertyValueFactory<>("approveInvestmentProposal"));
        aTitleCo.setCellValueFactory(new PropertyValueFactory<>("investmentTitle"));
        ammountCo.setCellValueFactory(new PropertyValueFactory<>("investmentAmount"));
        nameCo.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        performanceRatingCol.setCellValueFactory(new PropertyValueFactory<>("performanceRating"));
        performanceRatingComboBox.getItems().addAll("Excellent","Good","Satisfactory");
        viewApproveProposals();
    }

    @javafx.fxml.FXML
    public void showAllEvaluationOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal8b_evaluateinvestorperformance.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void addEvaluationOnActionButton(ActionEvent actionEvent) {
        String performanceRating = performanceRatingComboBox.getValue();
        String investmentTitle = investmentNameComboBox.getValue();
        if(performanceRating.isEmpty() || investmentTitle.isEmpty()) {
            showAlert("Validation Error","All fields are required");
            return;
        }
        ObjectInputStream ois = null;
        try {
            ApproveInvestmentProposals a;
            ois = new ObjectInputStream(new FileInputStream("approvedinvestmentproposals.bin"));
            while (true){
                a= (ApproveInvestmentProposals) ois.readObject();
                if(a.getInvestmentTitle().equals(investmentTitle)){
                    InvestorPerformance i=new InvestorPerformance(a.getInvestmentTitle(),a.getInvestmentAmount(),a.getCompanyName(),a.getProjectDescription(),a.getDocuments(),a.getApproveInvestmentProposal(),performanceRating);
                    writeInvestorPerformance(i);

                }

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
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/doIDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    public void viewApproveProposals(){
        ObjectInputStream ois = null;
        try {
            ApproveInvestmentProposals a;
            ois = new ObjectInputStream(new FileInputStream("approvedinvestmentproposals.bin"));
            while (true){
                a= (ApproveInvestmentProposals) ois.readObject();
                approvalTable.getItems().add(a);
                investmentNameComboBox.getItems().add(a.getInvestmentTitle());

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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void writeInvestorPerformance(InvestorPerformance investorPerformance){
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("approvedinvestorperformance.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(investorPerformance);
            evaluateTable.getItems().add(investorPerformance);
            performanceRatingComboBox.setValue(null);
            investmentNameComboBox.setValue(null);


        }catch(IOException ex){
            Logger.getLogger(Goal8EvaluateinvestorperformanceController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal8EvaluateinvestorperformanceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }
}