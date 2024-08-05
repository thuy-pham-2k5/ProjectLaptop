package com.example.ngay1;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    private ArrayList<Admin> adminList = new ArrayList<>();

    public HelloController() {
        // Dữ liệu mẫu cho admin
        adminList.add(new Admin("admin1", "password1"));
        adminList.add(new Admin("admin2", "password2"));
        adminList.add(new Admin("admin3", "password3"));
        adminList.add(new Admin("admin4", "password4"));
        adminList.add(new Admin("admin5", "password5"));
    }

    @FXML
    private void handleLogin() {
        String username = userTextField.getText();
        String password = passwordField.getText();

        // Kiểm tra thông tin đăng nhập
        boolean loginSuccessful = adminList.stream()
                .anyMatch(admin -> admin.getUsername().equals(username) && admin.getPassword().equals(password));

        if (loginSuccessful) {
            messageLabel.setText("Login successful!");
            messageLabel.setStyle("-fx-text-fill: green;");

            // Chuyển sang giao diện quản lý sản phẩm sau khi đăng nhập thành công
            try {
                Stage stage = (Stage) userTextField.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/ngay1/product-view.fxml"));
                stage.setScene(new Scene(root, 1600, 1000));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            messageLabel.setText("Invalid username or password.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
