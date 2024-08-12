package com.example.shop_laptop.signin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    // Danh sách người dùng và mật khẩu
    private final UserDataBase userDatabase = new UserDataBase();

    @FXML
    protected void login() {
        String usernameText = this.username.getText();
        String passwordText = this.password.getText();

        // Kiểm tra thông tin đăng nhập
        if (userDatabase.validateCredentials(usernameText, passwordText)) {
            // Đăng nhập thành công, chuyển hướng đến cảnh mới
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/shop_laptop/product_list.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) username.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("4P Tech Store");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Có lỗi xảy ra khi chuyển cảnh.");
                alert.show();
            }
        } else {
            // Đăng nhập thất bại
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Tên người dùng hoặc mật khẩu không đúng.");
            alert.show();

            //Xóa nội dung trường đăng nhập
            username.clear();
            password.clear();
            //Đặt con trỏ vào trường username
            username.requestFocus();
        }
    }
}
