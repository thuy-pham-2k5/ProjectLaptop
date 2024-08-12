package com.example.shop_laptop.signin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class LoginMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Kiểm tra xem tìm thấy đường dẫn file FXMl hay không
        URL fxmlLocation = LoginMain.class.getResource("/com/example/shop_laptop/login-view.fxml");
        if (fxmlLocation==null) {
            System.out.println("khong tim thay");
        } else {
            System.out.println("tim thay");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/shop_laptop/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);

        //Áp dụng CSS để đặt hình nền
        scene.getStylesheets().add(getClass().getResource("/com/example/shop_laptop/style.css").toExternalForm());

        stage.setTitle("4P Tech Store");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
