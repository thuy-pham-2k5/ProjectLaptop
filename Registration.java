package com.example.shop_laptop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Registration extends Application {

    private TextField nameField;
    private TextField emailField;
    private PasswordField passwordField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration");
        GridPane gridPane = createRegistrationFormPane();
        Scene scene = new Scene(gridPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private GridPane createRegistrationFormPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints columnConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnConstraints, columnTwoConstrains);

        addUIControls(gridPane);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        Label headerLabel = new Label("Đăng ký");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        Label nameLabel = new Label("Username : ");
        gridPane.add(nameLabel, 0, 1);

        nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1, 1);

        Label emailLabel = new Label("Email: ");
        gridPane.add(emailLabel, 0, 2);

        emailField = new TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 2);

        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);

        passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);

        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Xóa tất cả tooltips trước khi kiểm tra
                nameField.setTooltip(null);
                emailField.setTooltip(null);
                passwordField.setTooltip(null);

                if (nameField.getText().isEmpty()) {
                    Tooltip nameTooltip = new Tooltip("Please enter your name");
                    nameField.setTooltip(nameTooltip);
                    return;
                }
                if (emailField.getText().isEmpty()) {
                    Tooltip emailTooltip = new Tooltip("Please enter your email");
                    emailField.setTooltip(emailTooltip);
                    return;
                }
                if (passwordField.getText().isEmpty()) {
                    Tooltip passwordTooltip = new Tooltip("Please enter your password");
                    passwordField.setTooltip(passwordTooltip);
                    return;
                }

                // Nếu tất cả các trường đã được nhập
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
                        "Registration Successful!", "Welcome " + nameField.getText());
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
