package com.example.simulating_operations_of_an_epz.yousuf.chiefFinancialOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SkillsDevolapmentWorkshopController {

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> employeeIdColumn;

    @FXML
    private ComboBox<?> employeecombobox;

    @FXML
    private TableColumn<?, ?> skillsColumn;

    @FXML
    private DatePicker workShopDatePicker;

    @FXML
    private TextField workShopTitletextfield;

    @FXML
    private TableColumn<?, ?> workshoptitleColumn;
    @FXML
    private TableView tableColumn;
    @FXML
    private ComboBox skillsComboBox;

    @FXML
    void addButton(ActionEvent event) {

    }

    @FXML
    void showButton(ActionEvent event) {

    }

    @FXML
    public void backbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();}
}
