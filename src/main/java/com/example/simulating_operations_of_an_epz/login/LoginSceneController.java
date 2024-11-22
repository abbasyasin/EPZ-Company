package com.example.simulating_operations_of_an_epz.login;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class LoginSceneController {
    @javafx.fxml.FXML
    private TextField emailOrUserIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private PasswordField passwordTextField;

    @javafx.fxml.FXML
    void initialize() {
        userTypeComboBox.setValue("Select User Type");
        userTypeComboBox.getItems().addAll("Executive Chairman","Director of Investment Promotion",
                                            "Chief Financial Officer","Chief Security Officer",
                                                "Company","Director of Business and Enterprise services",
                                                "Director of Infrastructure and Development","Environmental and Safety Officer");

    }

    @javafx.fxml.FXML
    public void createNewAccountButtonOnClicked(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/login/signupScene.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Signup");
        window.setScene(scene2);
        window.show();
    }

    @javafx.fxml.FXML
    public void signInButtonOnClicked(ActionEvent actionEvent) throws IOException {
        String emailOrUserId = emailOrUserIdTextField.getText();
        String password = passwordTextField.getText();
        String userType = userTypeComboBox.getValue();

        com.example.simulating_operations_of_an_epz.login.LoginValidationAndVerification loginValidationAndVerification = new com.example.simulating_operations_of_an_epz.login.LoginValidationAndVerification();
        if (loginValidationAndVerification.validateEmailOrId(emailOrUserId) && loginValidationAndVerification.validatePassword(password)) {
            Parent dashboardScene = switch (userType) {
                case "Executive Chairman" ->
                        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/executivechairmanaDashboardController.fxml")));
                case "Director of Investment Promotion" ->
                        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/DoIDashboardController.fxml")));
                case "Chief Financial Officer" ->
                        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml")));
                case "Chief Security Officer" ->
                        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/CsODashboardController.fxml")));
                case "Company" ->
                        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/company/CompanyDashboardController.fxml")));
                case "Director of Business and Enterprise services" ->
                        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/dBEnterpriseService/DobedashbordController.fxml")));
                case "Director of Infrastructure and Development" ->
                        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/diFdDashboardController.fxml")));
                case "Environmental and Safety Officer" ->
                        FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/environmentalandSafetyOfficer/eNsOfficerDasboardcontroller.fxml")));
                default -> throw new IllegalArgumentException("Invalid user type: " + userType);
            };
            Scene scene = new Scene(dashboardScene);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setTitle(userType + " Dashboard");
            window.setScene(scene);
            window.show();
        } else {
            System.out.println("Invalid Email or User ID or Password");
        }
    }

    @javafx.fxml.FXML
    public void forgotPasswordButtonOnClicked(ActionEvent actionEvent) {
    }
}
