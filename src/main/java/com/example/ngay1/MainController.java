package com.example.ngay1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MainController {
    @FXML
    private void showLogin(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/ngay1/hello-view.fxml"));
        stage.setScene(new Scene(root, 1600, 1000));
    }

    @FXML
    private void showProductManagement(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/ngay1/product-view.fxml"));
        stage.setScene(new Scene(root, 1600, 1000));
    }
}
