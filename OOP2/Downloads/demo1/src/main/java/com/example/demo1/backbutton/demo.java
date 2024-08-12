package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class demo extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Scene Switcher");

        // Tạo các cảnh
        // Cảnh 1
        Button btnToScene2 = new Button("Go to Scene 2");

        HBox layout1 = new HBox(20);
        layout1.getChildren().add(btnToScene2);
        Scene scene1 = new Scene(layout1, 300, 200);

        // Cảnh 2
        Button btnToScene1 = new Button("Go to Scene 1");
        Button btnHelloWorld = new Button("Hello World");

        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(btnHelloWorld, btnToScene1);
        Scene scene2 = new Scene(layout2, 300, 200);

        // Cài đặt hành động cho các nút
        btnToScene2.setOnAction(event -> primaryStage.setScene(scene2));
        btnToScene1.setOnAction(event -> primaryStage.setScene(scene1));

        // Đặt cảnh ban đầu cho Stage
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
        //Vốn tạo nút back
    public static void main(String[] args) {
        launch(args);
    }
}
