package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.Goal7ReviewincedentreportsController;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.RemarksOfIncidentReport;
import com.example.simulating_operations_of_an_epz.yousuf.chiefSecurityOfficer.IncidentReport;
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

public class Goal7ApproveinvestmentproposalsController {
    @javafx.fxml.FXML
    private ComboBox<String> aprrovalComboBox;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals, Double> acol;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals, String> dCol;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals, String> cCol;
    @javafx.fxml.FXML
    private TableView<DummyInvestmentProposals> dummmyInvestmentTable;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals, String> desCol;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals, String> tcol;
    @javafx.fxml.FXML
    private ComboBox<String> proposalComboBox;
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
    public void initialize() {
        tcol.setCellValueFactory(new PropertyValueFactory<>("investmentTitle"));
        acol.setCellValueFactory(new PropertyValueFactory<>("investmentAmount"));
        cCol.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        dCol.setCellValueFactory(new PropertyValueFactory<>("documents"));
        desCol.setCellValueFactory(new PropertyValueFactory<>("projectDescription"));
        aTitleCol.setCellValueFactory(new PropertyValueFactory<>("investmentTitle"));
        ammountCol.setCellValueFactory(new PropertyValueFactory<>("investmentAmount"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        docCol.setCellValueFactory(new PropertyValueFactory<>("documents"));
        approvalCol.setCellValueFactory(new PropertyValueFactory<>("approveInvestmentProposal"));
        storeInvestmentTitleComboBox();
        viewInvestmentProposals();
        aprrovalComboBox.getItems().addAll("Approved","Rejected");

    }

    public void storeInvestmentTitleComboBox(){
        ObjectInputStream ois = null;
        try {
            DummyInvestmentProposals d;
            ois = new ObjectInputStream(new FileInputStream("dummyinvestmentproposals.bin"));
            while (true){
                d= (DummyInvestmentProposals) ois.readObject();
                proposalComboBox.getItems().add(d.getInvestmentTitle());
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
    public void viewInvestmentProposals(){
        ObjectInputStream ois = null;
        try {
            DummyInvestmentProposals d;
            ois = new ObjectInputStream(new FileInputStream("dummyinvestmentproposals.bin"));
            while (true){
                d= (DummyInvestmentProposals) ois.readObject();
                dummmyInvestmentTable.getItems().add(d);
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
    public void appovalOnActionButton(ActionEvent actionEvent) {
        String proposalName=proposalComboBox.getValue();
        String approval=aprrovalComboBox.getValue();
        if(proposalName.isEmpty() || approval.isEmpty()){
            showAlert("Validation Error","All fields are required");
            return;
        }

        ObjectInputStream ois = null;
        try {
            DummyInvestmentProposals d;
            ois = new ObjectInputStream(new FileInputStream("dummyinvestmentproposals.bin"));
            while (true){
                d= (DummyInvestmentProposals) ois.readObject();
                if(d.getInvestmentTitle().equals(proposalName)){
                    if(approval.equals("Approved")){
                        ApproveInvestmentProposals a=new ApproveInvestmentProposals(d.getInvestmentTitle(),d.getInvestmentAmount(),d.getCompanyName(),d.getProjectDescription(),d.getDocuments(),approval);
                        writeApprovedProposal(a);
                        writeAllProposal(a);
                        proposalComboBox.setValue(null);
                        aprrovalComboBox.setValue(null);
                    }
                    if(approval.equals("Rejected")){
                        ApproveInvestmentProposals b=new ApproveInvestmentProposals(d.getInvestmentTitle(),d.getInvestmentAmount(),d.getCompanyName(),d.getProjectDescription(),d.getDocuments(),approval);
                        writeRejectedProposal(b);
                        writeAllProposal(b);
                        proposalComboBox.setValue(null);
                        aprrovalComboBox.setValue(null);

                    }
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
    public void loadAllProposalsOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal7b_approveinvestmentproposals.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void writeApprovedProposal(ApproveInvestmentProposals approveInvestmentProposals){
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("approvedinvestmentproposals.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(approveInvestmentProposals);
            approvalTable.getItems().add(approveInvestmentProposals);


        }catch(IOException ex){
            Logger.getLogger(Goal7ApproveinvestmentproposalsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal7ApproveinvestmentproposalsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

    public void writeAllProposal(ApproveInvestmentProposals a){
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("allinvestmentproposals.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(a);


        }catch(IOException ex){
            Logger.getLogger(Goal7ApproveinvestmentproposalsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal7ApproveinvestmentproposalsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

    public void writeRejectedProposal(ApproveInvestmentProposals d){
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("rejectedinvestmentproposals.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            oos.writeObject(d);
            approvalTable.getItems().add(d);


        }catch(IOException ex){
            Logger.getLogger(Goal7ApproveinvestmentproposalsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal7ApproveinvestmentproposalsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }
}