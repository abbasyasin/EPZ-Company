package com.example.simulating_operations_of_an_epz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/example/simulating_operations_of_an_epz/login/LoginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome to EPZ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}