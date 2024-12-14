package com.example.simulating_operations_of_an_epz.abbas.executiveChairman;

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
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Goal2bShowchairmanNotesController
{
    @javafx.fxml.FXML
    private TableColumn<Note,String> titlecol;
    @javafx.fxml.FXML
    private TableColumn<Note,String> attachmentcol;
    @javafx.fxml.FXML
    private TableColumn<Note, LocalDate> datecol;
    @javafx.fxml.FXML
    private TableColumn<Note,String> categorycol;
    @javafx.fxml.FXML
    private TableView<Note> noteTable;

    @javafx.fxml.FXML
    public void initialize() {
        titlecol.setCellValueFactory(new PropertyValueFactory<>("title"));
        categorycol.setCellValueFactory(new PropertyValueFactory<>("category"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        attachmentcol.setCellValueFactory(new PropertyValueFactory<>("attachmentName"));
        loadNotes();
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/goal2_chairmannotes.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Yearly Budget");
        window.setScene(scene2);
        window.show();
    }
    private void loadNotes(){
        ObjectInputStream ois = null;
        try {
            Note s;
            ois = new ObjectInputStream(new FileInputStream("chairmannotes.bin"));
            while (true){
                s= (Note) ois.readObject();
                noteTable.getItems().add(s);
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
    public void deleteANoteOnActionbutton(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<Note> selectionModel = noteTable.getSelectionModel();
        if(selectionModel.isEmpty()) {
            System.out.println("select a data before deleting");
        }
        ObservableList<Integer> selectedIndices=selectionModel.getSelectedIndices();
        Integer[] indicesArray=selectedIndices.toArray(new Integer[0]);
        Arrays.sort(indicesArray);
        ObservableList<Note> remainingNotes= FXCollections.observableArrayList(noteTable.getItems());


        for(int i = indicesArray.length-1;i>=0;i--) {
            int index=indicesArray[i];
            remainingNotes.remove(noteTable.getItems().get(index));
            noteTable.getItems().remove(index);

        }
        updateNoteFile(remainingNotes,"chairmannotes.bin");
    }

    private void updateNoteFile(ObservableList<Note> data,String filename) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))) {
            for(Note note:data) {
                oos.writeObject(note);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}