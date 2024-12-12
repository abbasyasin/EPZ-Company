package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.Goal7ReviewincedentreportsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DummyInvestmentProposalController
{
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals,Double> acol;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals,String> dCol;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals,String> cCol;
    @javafx.fxml.FXML
    private TableView<DummyInvestmentProposals> dummmyInvestmentTable;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals,String> desCol;
    @javafx.fxml.FXML
    private TableColumn<DummyInvestmentProposals,String> tcol;

    @javafx.fxml.FXML
    public void initialize() {
        tcol.setCellValueFactory(new PropertyValueFactory<>("investmentTitle"));
        acol.setCellValueFactory(new PropertyValueFactory<>("investmentAmount"));
        cCol.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        dCol.setCellValueFactory(new PropertyValueFactory<>("documents"));
        desCol.setCellValueFactory(new PropertyValueFactory<>("projectDescription"));
    }

    @javafx.fxml.FXML
    public void createInvestmentProposalOnActionButton(ActionEvent actionEvent) {
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
            DummyInvestmentProposals d1=new DummyInvestmentProposals("Green Energy Solar Plant",5000000,"SunTech Renewable Energy","Establishing a solar panel manufacturing plant within EPZ","All Documents Available");
            DummyInvestmentProposals d2=new DummyInvestmentProposals("Tech Assembly Line Expansion",2500000,"Shenzen Electronics Inc","Establishing a electronics manufacturing plant within EPZ","Documents Missing");
            DummyInvestmentProposals d3=new DummyInvestmentProposals("Denim Garments production",3000000,"Dhaka Textiles Ltd.","Establishing a denim garments production plant within EPZ","All Documents Available");
            oos.writeObject(d1);
            oos.writeObject(d2);
            oos.writeObject(d3);
            dummmyInvestmentTable.getItems().add(d1);
            dummmyInvestmentTable.getItems().add(d2);
            dummmyInvestmentTable.getItems().add(d3);


        }catch(IOException ex){
            Logger.getLogger(DummyInvestmentProposalController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(DummyInvestmentProposalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @javafx.fxml.FXML
    public void backActionButton(ActionEvent actionEvent) throws IOException{
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/doIDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }
}