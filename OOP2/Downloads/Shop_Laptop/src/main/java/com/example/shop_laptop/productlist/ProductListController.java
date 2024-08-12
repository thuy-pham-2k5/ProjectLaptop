package com.example.shop_laptop.productlist;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductListController {

    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, Integer> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, Integer> priceColumn;
    @FXML
    private TableColumn<Product, Void> actionColumn;
    @FXML
    private Button addButton;
    private ProductDataSaver dataSaver = new ProductDataSaver();

    public ProductListController() {}
    public ProductListController(TableColumn<Product, Integer> priceColumn, Button addButton) {
        this.priceColumn = priceColumn;
        this.addButton = addButton;
    }

    @FXML
    public void initialize() {
        // Thiết lập cột
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Cột hành động với nút Edit và Delete
        actionColumn.setCellFactory(new Callback<TableColumn<Product, Void>, TableCell<Product, Void>>() {
            @Override
            public TableCell<Product, Void> call(TableColumn<Product, Void> param) {
                return new EditButtonCell(ProductListController.this);
            }
        });
        // Tải dữ liệu từ tệp tin và thêm vào bảng
        List<Product> products = dataSaver.loadData();
        tableView.setItems(FXCollections.observableArrayList(products));
    }

    @FXML
    private void handleAddButtonAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/shop_laptop/add_product.fxml"));
        Parent root = loader.load();

        AddProductController controller = loader.getController();
        controller.setParentController(this);

        Stage stage = new Stage();
        stage.setTitle("Add Product");
        stage.setScene(new Scene(root, 300, 200));
        stage.show();
    }

    public void addProduct(Product product) {
        tableView.getItems().add(product);
        // Lưu lại dữ liệu sau khi thêm sản phẩm
        dataSaver.saveData(new ArrayList<>(tableView.getItems()));
    }

    public void deleteProduct(Product product) {
        tableView.getItems().remove(product);
        // Lưu lại dữ liệu sau khi xóa sinh viên
        dataSaver.saveData(new ArrayList<>(tableView.getItems()));
    }

    public void updateProduct(Product oldProduct, Product newProduct) {
        int index = tableView.getItems().indexOf(oldProduct);
        if (index != -1) {
            tableView.getItems().set(index, newProduct);
            // Lưu lại dữ liệu sau khi cập nhật sinh viên
            dataSaver.saveData(new ArrayList<>(tableView.getItems()));
        }
    }

    public void goToPage1(ActionEvent actionEvent) {

    }

    public void goToPage2(ActionEvent actionEvent) {
    }

    public void goToPage3(ActionEvent actionEvent) {
    }
}
