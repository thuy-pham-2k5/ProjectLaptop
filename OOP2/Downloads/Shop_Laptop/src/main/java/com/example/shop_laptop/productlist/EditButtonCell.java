package com.example.shop_laptop.productlist;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Optional;

import java.io.IOException;

public class EditButtonCell extends TableCell<Product, Void> {
    private final Button editButton = new Button("Edit");
    private final Button deleteButton = new Button("Delete");
    private final ProductListController controller;

    public EditButtonCell(ProductListController controller) {
        this.controller = controller;

        // Handle Edit button action
        editButton.setOnAction(event -> {
            Product product = getTableView().getItems().get(getIndex());
            showEditDialog(product);
        });

        // Handle Delete button action
        deleteButton.setOnAction(event -> {
            Product product = getTableView().getItems().get(getIndex());
            showConfirmationDialog(product);
        });
    }

    private void showEditDialog(Product product) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/shop_laptop/edit_product.fxml"));
            Parent root = loader.load();

            EditProductController editController = loader.getController();
            editController.setProduct(product);

            Stage stage = new Stage();
            stage.setTitle("Edit Product");
            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(new Scene(root, 300, 200));
            stage.showAndWait();

            if (editController.isConfirmed()) {
                Product updatedProduct = editController.getProduct();
                controller.updateProduct(product, updatedProduct);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showConfirmationDialog(Product product) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Deletion");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this product?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            controller.deleteProduct(product);
        }
    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            HBox hBox = new HBox(10, editButton, deleteButton);
            setGraphic(hBox);
        }
    }
}
