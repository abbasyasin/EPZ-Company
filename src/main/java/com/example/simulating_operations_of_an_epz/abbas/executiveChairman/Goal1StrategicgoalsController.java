package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Goal1StrategicgoalsController
{
    @javafx.fxml.FXML
    private DatePicker deadlinePicker;
    @javafx.fxml.FXML
    private TableColumn<StrategicGoal,String> titlecol;
    @javafx.fxml.FXML
    private ComboBox<String> priorityBox;
    @javafx.fxml.FXML
    private TextField titleField;
    @javafx.fxml.FXML
    private ComboBox<String> categoryBox;
    @javafx.fxml.FXML
    private TableColumn<StrategicGoal,LocalDate> deadlinecol;
    @javafx.fxml.FXML
    private TableView<StrategicGoal> goalsTable;
    @javafx.fxml.FXML
    private TableColumn<StrategicGoal,String> prioritycol;
    @javafx.fxml.FXML
    private TableColumn<StrategicGoal,String> categorycol;
    @javafx.fxml.FXML
    private TextField descriptionField;
    @javafx.fxml.FXML
    private TableColumn<StrategicGoal,String> descriptioncol;

    @javafx.fxml.FXML
    public void initialize() {
        categoryBox.getItems().addAll("Development","Finance","Safety");
        priorityBox.getItems().addAll("High","Medium","Low");
        titlecol.setCellValueFactory(new PropertyValueFactory<StrategicGoal,String>("title"));
        categorycol.setCellValueFactory(new PropertyValueFactory<>("category"));
        deadlinecol.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        prioritycol.setCellValueFactory(new PropertyValueFactory<>("priority"));
        descriptioncol.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    @javafx.fxml.FXML
    public void ShowAllGoalsOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal1b_loadstrategicgoals.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void addgoalOnActionButton(ActionEvent actionEvent) {
        String title = titleField.getText();
        String description = descriptionField.getText();
        String category=categoryBox.getValue();
        String priority=priorityBox.getValue();
        LocalDate deadline=deadlinePicker.getValue();
        if(title.isEmpty() || description.isEmpty() || category==null || priority==null || deadline==null){
            showAlert("Validation Error","All fields are required");
            return;

        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("strategicgoals.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            StrategicGoal goal=new StrategicGoal(title,description,category,priority,deadline);
            goalsTable.getItems().add(goal);
            oos.writeObject(goal);
            titleField.clear();
            descriptionField.clear();
            categoryBox.setValue(null);
            priorityBox.setValue(null);
            deadlinePicker.setValue(null);

        }catch(IOException ex){
            Logger.getLogger(Goal1StrategicgoalsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal1StrategicgoalsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}