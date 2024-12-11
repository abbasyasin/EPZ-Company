package com.example.simulating_operations_of_an_epz.login;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.VisionStatement;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    public void forgotPasswordButtonOnClicked(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loginUserOnActionButton(ActionEvent actionEvent) {
        String emailOrUserId = emailOrUserIdTextField.getText();
        String password = passwordTextField.getText();
        String userType = userTypeComboBox.getValue();

        com.example.simulating_operations_of_an_epz.login.LoginValidationAndVerification loginValidationAndVerification = new com.example.simulating_operations_of_an_epz.login.LoginValidationAndVerification();
        if (loginValidationAndVerification.validateEmailOrId(emailOrUserId) && loginValidationAndVerification.validatePassword(password)){
            attemptLogin();

        }else{
            System.out.println("Invalid Email or User ID or Password");
        }
    }

    public void attemptLogin(){
        ObjectInputStream ois = null;
        try {
            User d;
            ois = new ObjectInputStream(new FileInputStream("user.bin"));
            while (true){
                d= (User) ois.readObject();
                if(d.isEmail(emailOrUserIdTextField.getText()) && d.isPassword(passwordTextField.getText()) && d.isUserType(userTypeComboBox.getValue())){
                    System.out.println("login successful");
                    String optionChosen=userTypeComboBox.getValue();
                    if(optionChosen.equals("Executive Chairman")){
                        ExecutiveChairman j1=new ExecutiveChairman(d.getEmail(),d.getPassword(),d.getUsertype());
                        loginExecutiveChairman(j1);
                    }
                    if(optionChosen.equals("Director of Investment Promotion")){
                        DirectorofInvestmentPromotion j2=new DirectorofInvestmentPromotion(d.getEmail(),d.getPassword(),d.getUsertype());
                        loginDirectorOfInVestmentPromotion(j2);
                    }
                    if(optionChosen.equals("Chief Financial Officer")){
                        ChiefFinancialOfficer j3=new ChiefFinancialOfficer(d.getEmail(),d.getPassword(),d.getUsertype());
                        loginCFO(j3);
                    }
                    if(optionChosen.equals("Chief Security Officer")){
                        ChiefSecurityOfficer j4=new ChiefSecurityOfficer(d.getEmail(),d.getPassword(),d.getUsertype());
                        loginCSO(j4);

                    }
                    if(optionChosen.equals("Company")){
                        CompanyUser j5=new CompanyUser(d.getEmail(),d.getPassword(),d.getUsertype());
                        loginCompany(j5);

                    }
                    if(optionChosen.equals("Director of Business and Enterprise services")){
                        DirectorofBusinessandEnterpriseservices j6=new DirectorofBusinessandEnterpriseservices(d.getEmail(),d.getPassword(),d.getUsertype());
                        loginDBO(j6);
                    }
                    if(optionChosen.equals("Director of Infrastructure and Development")){
                        DirectorofInfrastructureandDevelopment j7=new DirectorofInfrastructureandDevelopment(d.getEmail(),d.getPassword(),d.getUsertype());
                        loginDID(j7);

                    }
                    if(optionChosen.equals("Environmental and Safety Officer")){
                        EnvironmentalandSafetyOfficer j8=new EnvironmentalandSafetyOfficer(d.getEmail(),d.getPassword(),d.getUsertype());
                        loginEnvironmentOfficer(j8);

                    }
                }
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
    public void loginExecutiveChairman(ExecutiveChairman u) throws Exception{
        Stage stage=(Stage) emailOrUserIdTextField.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/executiveChairman/executivechairmanaDashboardController.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Executive Chairman");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loginDirectorOfInVestmentPromotion(DirectorofInvestmentPromotion u) throws Exception{
        Stage stage=(Stage) emailOrUserIdTextField.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/simulating_operations_of_an_epz/abbas/directorofInvestmentPromotion/DoIDashboardController.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Director of Investment Promotion");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void loginCFO(ChiefFinancialOfficer u) throws Exception{
        Stage stage=(Stage) emailOrUserIdTextField.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefFinancialOfficer/CfODashboardcontroller.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Cheif Financial Officer");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void loginCSO(ChiefSecurityOfficer u) throws Exception{
        Stage stage=(Stage) emailOrUserIdTextField.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/simulating_operations_of_an_epz/yousuf/chiefSecurityOfficer/CsODashboardController.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Cheif Security Officer");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void loginCompany(CompanyUser u) throws Exception{
        Stage stage=(Stage) emailOrUserIdTextField.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/company/CompanyDashboardController.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Company");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void loginDBO(DirectorofBusinessandEnterpriseservices u) throws Exception{
        Stage stage=(Stage) emailOrUserIdTextField.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/simulating_operations_of_an_epz/rathna/dBEnterpriseService/DobedashbordController.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Director Of Business And Enterprise Services");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void loginDID(DirectorofInfrastructureandDevelopment u) throws Exception{
        Stage stage=(Stage) emailOrUserIdTextField.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/directorofInfrastructureandDevelopment/diFdDashboardController.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Director Of Infrastructure and Development");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void loginEnvironmentOfficer(EnvironmentalandSafetyOfficer u) throws Exception{
        Stage stage=(Stage) emailOrUserIdTextField.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/simulating_operations_of_an_epz/nibir/environmentalandSafetyOfficer/eNsOfficerDasboardcontroller.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Environment And Safety Officer");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
