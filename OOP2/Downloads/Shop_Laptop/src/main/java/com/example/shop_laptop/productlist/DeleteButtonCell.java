package com.example.shop_laptop.productlist;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class DeleteButtonCell extends TableCell<Product, Void> {
    private final Button deleteButton = new Button("Delete");
    private final ProductListController controller;

    public DeleteButtonCell(ProductListController controller) {
        this.controller = controller;

        deleteButton.setOnAction(event -> {
            Product product = getTableView().getItems().get(getIndex());
            showConfirmationDialog(product);
        });
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
            setGraphic(new HBox(deleteButton));
        }
    }
}
