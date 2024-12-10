package com.example.simulating_operations_of_an_epz.abbas.directorofInvestmentPromotion;

import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
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

public class Goal6OrganizenetworkingeventsforinvesotrsController
{
    @javafx.fxml.FXML
    private TextField EventNametextField;
    @javafx.fxml.FXML
    private TableColumn<NetworkingEvent,String> netVenueCol;
    @javafx.fxml.FXML
    private TableColumn<NetworkingEvent,Integer> netParticipantsCol;
    @javafx.fxml.FXML
    private TextField participantField;
    @javafx.fxml.FXML
    private TextField venueTextfield;
    @javafx.fxml.FXML
    private DatePicker networkingDatePicker;
    @javafx.fxml.FXML
    private TableColumn<NetworkingEvent,LocalDate> netEventDateCol;
    @javafx.fxml.FXML
    private TableColumn<NetworkingEvent,String> netDescriptionCol;
    @javafx.fxml.FXML
    private TextArea descriptionTextField;
    @javafx.fxml.FXML
    private TableView<NetworkingEvent> netEventTable;
    @javafx.fxml.FXML
    private TableColumn<NetworkingEvent,String> netEventNameCol;

    @javafx.fxml.FXML
    public void initialize() {
        netEventNameCol.setCellValueFactory(new PropertyValueFactory<NetworkingEvent,String>("eventName"));
        netEventDateCol.setCellValueFactory(new PropertyValueFactory<NetworkingEvent,LocalDate>("date"));
        netVenueCol.setCellValueFactory(new PropertyValueFactory<NetworkingEvent,String>("venue"));
        netParticipantsCol.setCellValueFactory(new PropertyValueFactory<NetworkingEvent,Integer>("expectedParticipants"));
        netDescriptionCol.setCellValueFactory(new PropertyValueFactory<NetworkingEvent,String>("description"));
    }

    @javafx.fxml.FXML
    public void addEventOnActionButton(ActionEvent actionEvent) {
        String eventName = EventNametextField.getText();
        LocalDate date = networkingDatePicker.getValue();
        String venue = venueTextfield.getText();
        String participantsText = participantField.getText();
        String description = descriptionTextField.getText();
        if(eventName.isEmpty() || date == null || venue.isEmpty() || participantsText.isEmpty() || description.isEmpty()) {
            showAlert("Validation Error","All fields are required");
            return;

        }
        int expectedParticipants;
        try {
            expectedParticipants = Integer.parseInt(participantsText);
        } catch (NumberFormatException e) {
            showAlert("Validation Error","Participant number must be an integer");
            return;
        }

        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("networkingevents.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            NetworkingEvent n=new NetworkingEvent(eventName,date,venue,expectedParticipants,description);
            netEventTable.getItems().add(n);
            oos.writeObject(n);
            EventNametextField.clear();
            networkingDatePicker.setValue(null);
            venueTextfield.clear();
            participantField.clear();
            descriptionTextField.clear();

        }catch(IOException ex){
            Logger.getLogger(Goal6OrganizenetworkingeventsforinvesotrsController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(Goal6OrganizenetworkingeventsforinvesotrsController.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    @javafx.fxml.FXML
    public void LoadAllEventsOnActionButton(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/goal6b_organizenetworkingeventsforinvesotrs.fxml")));
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