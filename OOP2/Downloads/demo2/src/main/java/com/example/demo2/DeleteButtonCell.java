package com.example.demo2;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class DeleteButtonCell extends TableCell<Student, Void> {
    private final Button deleteButton = new Button("Delete");
    private final StudentListController controller;

    public DeleteButtonCell(StudentListController controller) {
        this.controller = controller;

        deleteButton.setOnAction(event -> {
            Student student = getTableView().getItems().get(getIndex());
            showConfirmationDialog(student);
        });
    }

    private void showConfirmationDialog(Student student) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Deletion");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this student?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            controller.deleteStudent(student);
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
