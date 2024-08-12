package com.example.shop_laptop.productlist;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;

    private ProductListController parentController;

    @FXML
    private void handleAdd() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(priceField.getText());

            Product newProduct = new Product(id, name, age);
            parentController.addProduct(newProduct);

            closeWindow();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter valid numbers for ID and Age.");
            alert.show();
        }
    }

    @FXML
    private void handleCancel() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) idField.getScene().getWindow();
        stage.close();
    }

    public void setParentController(ProductListController controller) {
        this.parentController = controller;
    }
}

