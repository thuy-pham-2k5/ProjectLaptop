package com.example.shop_laptop.productlist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class EditProductController {
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;

    private Product product;
    private boolean confirmed = false;

    @FXML
    private void initialize() {
        if (okButton == null) {
            System.err.println("okButton is null");
        } else {
            System.out.println("okButton is initialized successfully");
        }
    }


    public void setProduct(Product product) {
        this.product = product;
        idField.setText(String.valueOf(product.getId()));
        nameField.setText(product.getName());
        priceField.setText(String.valueOf(product.getPrice()));
    }

    public Product getProduct() {
        return product;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    @FXML
    private void handleOkAction(ActionEvent event) {
        // Hiển thị hộp thoại xác nhận
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận thay đổi");
        alert.setHeaderText(null);
        alert.setContentText("Bạn có chắc chắn muốn lưu thay đổi không?");

        // Thêm nút cho hộp thoại
        ButtonType okButton = new ButtonType("OK");
        ButtonType cancelButton = new ButtonType("Hủy");
        alert.getButtonTypes().setAll(okButton, cancelButton);

        // Hiển thị hộp thoại và chờ người dùng chọn
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == okButton) {
            // Nếu người dùng chọn OK, thực hiện thay đổi và đóng cửa sổ
            processChanges();
            closeWindow();
        }
        // Nếu người dùng chọn Hủy hoặc đóng hộp thoại, không làm gì cả
    }

    private void processChanges() {
        // Thực hiện các thay đổi ở đây
        // Ví dụ: lưu dữ liệu từ các trường TextField vào đối tượng product
        product.setId(Integer.parseInt(idField.getText()));
        product.setName(nameField.getText());
        product.setPrice(Integer.parseInt(priceField.getText()));
        confirmed = true;
    }


    @FXML
    private void handleCancelAction() {
        closeWindow();
    }

    private void closeWindow() {
        if (okButton != null && okButton.getScene() != null) {
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
        } else {
            System.err.println("Cannot close window: okButton or its scene is null");
        }
    }

}

