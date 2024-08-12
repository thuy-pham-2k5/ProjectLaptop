package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("demo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        primaryStage.setTitle("Hello world!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
