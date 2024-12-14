package com.example.simulating_operations_of_an_epz.nibir.environmentalandSafetyOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MonitorWasteManagementController
{
    @javafx.fxml.FXML
    private AnchorPane CompanynameTextField;
    @javafx.fxml.FXML
    private TextField violationTextField;
    @javafx.fxml.FXML
    private TextField companynameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> sendWarningComboBox;
    @javafx.fxml.FXML
    private TextField WastetypetextField;
    @javafx.fxml.FXML
    private TableColumn<WasteManagement, String> SendWarningTableColm;
    @javafx.fxml.FXML
    private TableColumn<WasteManagement, String> wastetypeTableColm;
    @javafx.fxml.FXML
    private TableColumn<WasteManagement, String> CompanynameTableColm;
    @javafx.fxml.FXML
    private TableView<WasteManagement> DataTableView;
    @javafx.fxml.FXML
    private TableColumn<WasteManagement, String> ViolationTableColm;

    private final ObservableList<WasteManagement> wasteManagementData = FXCollections.observableArrayList();
    private final ObservableList<String> warningOptions = FXCollections.observableArrayList("Yes", "No");

    @javafx.fxml.FXML
    public void initialize() {
        CompanynameTableColm.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        wastetypeTableColm.setCellValueFactory(new PropertyValueFactory<>("wasteType"));
        ViolationTableColm.setCellValueFactory(new PropertyValueFactory<>("violation"));
        SendWarningTableColm.setCellValueFactory(new PropertyValueFactory<>("sendWarning"));
        DataTableView.setItems(wasteManagementData);
        sendWarningComboBox.setItems(warningOptions);
    }

    @javafx.fxml.FXML
    public void BackButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/Nibir/environmentalandSafetyOfficer/eNsOfficerDasboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void submitActionButtonOnAction(ActionEvent actionEvent) {
        String companyName = companynameTextField.getText();
        String wasteType = WastetypetextField.getText();
        String violation = violationTextField.getText();
        String sendWarning = sendWarningComboBox.getValue();
        WasteManagement entry = new WasteManagement(companyName, wasteType, violation, sendWarning);
        wasteManagementData.add(entry);

        showAlert("Success", "Waste management data submitted successfully.");


    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
