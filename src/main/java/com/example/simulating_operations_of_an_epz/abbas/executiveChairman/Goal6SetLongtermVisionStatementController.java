package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Goal6SetLongtermVisionStatementController
{
    @javafx.fxml.FXML
    private TextField targetYearField;
    @javafx.fxml.FXML
    private TableColumn<VisionStatement,Integer> targetYearCol;
    @javafx.fxml.FXML
    private TextField statementField;
    @javafx.fxml.FXML
    private TableColumn<VisionStatement,String> statementCol;
    @javafx.fxml.FXML
    private TableView<VisionStatement> visionTable;

    @javafx.fxml.FXML
    public void initialize() {
        targetYearCol.setCellValueFactory(new PropertyValueFactory<>("targetYear"));
        statementCol.setCellValueFactory(new PropertyValueFactory<>("statement"));
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/executivechairmanaDashboardController.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void loadAllStatementOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal6b_setLongtermVisionStatement.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void addVisionOnActionButton(ActionEvent actionEvent) {
        String targetYearText = targetYearField.getText();
        String statement= statementField.getText();
        if(targetYearText.isEmpty() || statement.isEmpty()){
            showAlert("Validation Error", "Both Fields needed");
            return;

        }
        int targetYear;
        try{
            targetYear = Integer.parseInt(targetYearText);

        }catch (NumberFormatException e){
            showAlert("Validation Error", "Target Year must be an integer");
            return;
        }
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("visionstatements.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            VisionStatement vision=new VisionStatement(statement,targetYear);
            visionTable.getItems().add(vision);
            oos.writeObject(vision);
            targetYearField.clear();
            statementField.clear();

        }catch(IOException ex){
            Logger.getLogger(Goal6SetLongtermVisionStatementController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal6SetLongtermVisionStatementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}