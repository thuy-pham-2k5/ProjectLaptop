module com.example.shop_laptop {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.shop_laptop.signin to javafx.fxml;
    exports com.example.shop_laptop.signin;
    opens com.example.shop_laptop.productlist to javafx.fxml;
    exports com.example.shop_laptop.productlist;
}