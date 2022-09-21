package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBoardFormController {

    public AnchorPane DashBoardFormContext;

    public void signOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) DashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openRoomsForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/RoomForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) DashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openMealFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MealForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) DashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
