package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class demoController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    protected  void login() {
        String username = this.username.getText();
        String password = this.password.getText();

        if(username.equals("admin") && password.equals("password")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Login successful");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Login failed");
            alert.show();
        }
    }
}
