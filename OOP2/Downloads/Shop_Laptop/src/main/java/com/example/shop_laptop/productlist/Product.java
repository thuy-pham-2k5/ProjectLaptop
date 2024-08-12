package com.example.shop_laptop.productlist;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty price;

    public Product(int id, String name, int price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public int getPrice() {
        return price.get();
    }

    public void setName(String name) {
    }

    public void setId(int id) {
    }

    public void setPrice(int price) {
    }
}


