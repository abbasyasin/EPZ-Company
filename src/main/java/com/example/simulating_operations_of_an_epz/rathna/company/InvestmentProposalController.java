package com.example.simulating_operations_of_an_epz.rathna.company;

import com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion.DummyInvestmentProposalController;
import com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion.DummyInvestmentProposals;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvestmentProposalController
{
    @javafx.fxml.FXML
    private TextField CompanyNameTextField;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals,Double> acol;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals,String> dCol;
    @javafx.fxml.FXML
    private ComboBox<String> documentsComboBox;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals,String> cCol;
    @javafx.fxml.FXML
    private TextField proposalAmmountTextField;
    @javafx.fxml.FXML
    private TextField projectDescriptionTextField;
    @javafx.fxml.FXML
    private TextField proposaltitletextfield;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals,String> desCol;
    @javafx.fxml.FXML
    private TableView<DummyInvestmentProposals> InvestmentTable;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals,String> tcol;

    @javafx.fxml.FXML
    public void initialize() {
        tcol.setCellValueFactory(new PropertyValueFactory<>("investmentTitle"));
        acol.setCellValueFactory(new PropertyValueFactory<>("investmentAmount"));
        cCol.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        dCol.setCellValueFactory(new PropertyValueFactory<>("documents"));
        desCol.setCellValueFactory(new PropertyValueFactory<>("projectDescription"));
        documentsComboBox.getItems().addAll("All Documents Available","Documents Missing");
        viewInvestProposals();
    }

    @javafx.fxml.FXML
    public void submitProposalOnActionButton(ActionEvent actionEvent) {
        InvestmentTable.getItems().clear();
        String title=proposaltitletextfield.getText();
        String documents=documentsComboBox.getValue();
        String projectDescription=projectDescriptionTextField.getText();
        String companyName=CompanyNameTextField.getText();
        double investmentAmount=Double.parseDouble(proposalAmmountTextField.getText());

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("dummyinvestmentproposals.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            DummyInvestmentProposals d=new DummyInvestmentProposals(title,investmentAmount,companyName,projectDescription,documents);
            oos.writeObject(d);
            InvestmentTable.getItems().add(d);


        }catch(IOException ex){
            Logger.getLogger(InvestmentProposalController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(InvestmentProposalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @javafx.fxml.FXML
    public void loadAllProposalsOnActionButton(ActionEvent actionEvent) {
        InvestmentTable.getItems().clear();
        viewInvestProposals();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/company/companyDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("");
        window.setScene(scene2);
        window.show();
    }

    public void viewInvestProposals(){
        ObjectInputStream ois = null;
        try {
            DummyInvestmentProposals d;
            ois = new ObjectInputStream(new FileInputStream("dummyinvestmentproposals.bin"));
            while (true){
                d= (DummyInvestmentProposals) ois.readObject();
                InvestmentTable.getItems().add(d);
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