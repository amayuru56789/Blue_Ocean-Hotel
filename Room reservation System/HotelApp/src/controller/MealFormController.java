package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mdl.Meals;
import model.Rooms;
import view.mealTm.MealTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class MealFormController {

    public AnchorPane MealFormContext;
    public JFXTextField txtId;
    public JFXTextField txtPlan;
    public JFXTextField txtMeals;
    public JFXTextField txtPrice;
    public TableView tblMeals;
    public TableColumn colId;
    public TableColumn colPlan;
    public TableColumn colMeals;
    public TableColumn colPrice;
    public TableColumn colDelete;

    static ArrayList<Meals> mealsList = new ArrayList();

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPlan.setCellValueFactory(new PropertyValueFactory<>("plan"));
        colMeals.setCellValueFactory(new PropertyValueFactory<>("meals"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) MealFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void signOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) MealFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void newRoomOnAction(ActionEvent actionEvent) {
        Meals meals = new Meals(txtId.getText(),txtPlan.getText(),txtMeals.getText(),txtPrice.getText());

        if(isExists(meals)){
            if(mealsList.add(meals)){
                loadAllMeals();
                new Alert(Alert.AlertType.CONFIRMATION,"You can get a token...", ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Please try again...", ButtonType.CLOSE).show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING,"Not a token...", ButtonType.CLOSE).show();
        }
    }

    public boolean isExists(Meals rooms) {
        for (Meals t : mealsList
        ) {
            if (t.getId().equalsIgnoreCase(rooms.getId())) {
                return false;
            }
        }
        return true;
    }

    public void updateOnAction(ActionEvent actionEvent) {
        Meals meals = new Meals(txtId.getText(),txtPlan.getText(),txtMeals.getText(),txtPrice.getText());

        if(isExists(meals)){
            if(mealsList.add(meals)){
                loadAllMeals();
                new Alert(Alert.AlertType.CONFIRMATION,"You can get a token...", ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Please try again...", ButtonType.CLOSE).show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING,"Not a token...", ButtonType.CLOSE).show();
        }

    }
    public void loadAllMeals(){
        ObservableList<MealTM> tmObservableList = FXCollections.observableArrayList();
        for (Meals temp:mealsList
             ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new MealTM(temp.getId(), temp.getPlan(), temp.getMeals(),temp.getPrice(),btn)
            );
            btn.setOnAction((e)->{

                ButtonType yes= new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no= new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure Delete Package ? ",yes,no);
                Optional<ButtonType> result = alert.showAndWait();

                if(result.orElse(no)==yes){
                    mealsList.remove(temp);
                    loadAllMeals();
                }else {

                }
            });
        };
        tblMeals.setItems(tmObservableList);
    }

    public void moveToPlan(ActionEvent actionEvent) {
        txtPlan.requestFocus();
    }

    public void moveToMeals(ActionEvent actionEvent) {
        txtMeals.requestFocus();
    }

    public void moveToPrice(ActionEvent actionEvent) {
        txtPrice.requestFocus();
    }
}
