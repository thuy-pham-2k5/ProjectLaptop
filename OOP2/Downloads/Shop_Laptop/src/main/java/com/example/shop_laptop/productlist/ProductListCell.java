package com.example.shop_laptop.productlist;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class ProductListCell extends ListCell<Product> {
    private HBox content;
    private Label nameLabel;
    private Label priceLabel;

    public ProductListCell() {
        nameLabel = new Label();
        nameLabel.setFont(Font.font(14));

        priceLabel = new Label();
        priceLabel.setFont(Font.font(12));

        content = new HBox(10);
        content.getChildren().addAll(nameLabel, priceLabel);
    }

    @Override
    protected void updateItem(Product product, boolean empty) {
        super.updateItem(product, empty);

        if (empty || product == null) {
            setText(null);
            setGraphic(null);
        } else {
            nameLabel.setText(product.getName());
            priceLabel.setText("Price: " + product.getPrice());

            setText(null);
            setGraphic(content);
        }
    }
}
