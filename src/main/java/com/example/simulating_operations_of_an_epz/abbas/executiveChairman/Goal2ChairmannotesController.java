package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Goal2ChairmannotesController
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private ComboBox<String> categorybox;
    @javafx.fxml.FXML
    private TextField contentTextField;
    @javafx.fxml.FXML
    private DatePicker datepic;
    @javafx.fxml.FXML
    private TableView<Note> noteTable;
    @javafx.fxml.FXML
    private TableColumn<Note,String> titlecol;
    @javafx.fxml.FXML
    private TableColumn<Note,String> attachmentcol;
    @javafx.fxml.FXML
    private TableColumn<Note,LocalDate> datecol;
    @javafx.fxml.FXML
    private TableColumn<Note,String> categorycol;
    private File attachedFile;

    @javafx.fxml.FXML
    public void initialize() {
        categorybox.getItems().addAll("Meeting","Strategy","Event");
        titlecol.setCellValueFactory(new PropertyValueFactory<>("title"));
        categorycol.setCellValueFactory(new PropertyValueFactory<>("category"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        attachmentcol.setCellValueFactory(new PropertyValueFactory<>("attachmentName"));
    }

    @javafx.fxml.FXML
    public void saveNoteOnActionButton(ActionEvent actionEvent) {
        String title = titleTextField.getText();
        String content = contentTextField.getText();
        LocalDate date = datepic.getValue();
        String category = categorybox.getValue();
        if(title.isEmpty() || content.isEmpty() || category==null || date==null){
            showAlert("validation Error","All fields are required");
            return;

        }
        File f=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            f=new File("chairmannotes.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            //public Note(String title, String content, String category, LocalDate date, File attachment)
            Note note=new Note(title,content,category,date,attachedFile);
            noteTable.getItems().add(note);
            oos.writeObject(note);
            titleTextField.clear();
            contentTextField.clear();
            datepic.setValue(null);
            categorybox.setValue(null);
            attachedFile=null;

        }catch(IOException ex){
            Logger.getLogger(Goal2ChairmannotesController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal2ChairmannotesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @javafx.fxml.FXML
    public void attachfileOnActionButton(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        attachedFile = fileChooser.showOpenDialog(null);
    }

    @javafx.fxml.FXML
    public void loadAllNotesOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/Goal2b_showchairmanNotes.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
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