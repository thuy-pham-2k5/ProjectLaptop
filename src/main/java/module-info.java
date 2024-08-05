module com.example.ngay1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ngay1 to javafx.fxml;
    exports com.example.ngay1;
}