package com.example.simulating_operations_of_an_epz.login;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.AppendableObjectOutPutStream;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.Goal6SetLongtermVisionStatementController;
import com.example.simulating_operations_of_an_epz.abbas.executiveChairman.VisionStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignupSceneController {
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private TextField signUpPasswordTextField;

    @javafx.fxml.FXML
     void initialize() {
        userTypeComboBox.getItems().addAll("Executive Chairman","Director of Investment Promotion",
                "Chief Financial Officer","Chief Security Officer",
                "Company","Director of Business and Enterprise services",
                "Director of Infrastructure and Development","Environmental and Safety Officer");

    }

    @javafx.fxml.FXML
    public void signupButtonOnClicked(ActionEvent actionEvent) {
        String emailOrUserId = emailTextField.getText();
        String password = signUpPasswordTextField.getText();
        String userType = userTypeComboBox.getValue();

        com.example.simulating_operations_of_an_epz.login.LoginValidationAndVerification loginValidationAndVerification = new com.example.simulating_operations_of_an_epz.login.LoginValidationAndVerification();
        if (loginValidationAndVerification.validateEmailOrId(emailOrUserId) && loginValidationAndVerification.validatePassword(password)){
            attemptSignUp();
        }else {
            System.out.println("signup failed");
        }
    }

    @javafx.fxml.FXML
    public void signInButtonOnClicked(ActionEvent actionEvent) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulating_operations_of_an_epz/login/LoginScene.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Login Page");
        window.setScene(scene2);
        window.show();
    }

    public void attemptSignUp(){
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("user.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            User i=new User(emailTextField.getText(),signUpPasswordTextField.getText(),userTypeComboBox.getValue());

            oos.writeObject(i);
            emailTextField.clear();
            signUpPasswordTextField.clear();
            userTypeComboBox.setValue(null);
        }catch(IOException ex){
            Logger.getLogger(SignupSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(SignupSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
