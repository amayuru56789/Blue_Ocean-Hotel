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
import model.Rooms;
import view.tm.RoomsTm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class RoomFormController {
    public AnchorPane roomFormContext;
    public JFXTextField txtId;
    public JFXTextField txtType;
    public JFXTextField txtAvailability;
    public JFXTextField txtPrice;
    public TableView tblRoom;
    public TableColumn colId;
    public TableColumn colType;
    public TableColumn colAvailability;
    public TableColumn colPrice;
    public TableColumn colDelete;


    static ArrayList<Rooms> roomList = new ArrayList();

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    public void newRoomOnAction(ActionEvent actionEvent) {
        Rooms rooms = new Rooms(txtId.getText(),txtType.getText(),txtAvailability.getText(),txtPrice.getText());

        if(isExists(rooms)){

            if(roomList.add(rooms)){
                loadAllRooms();
                new Alert(Alert.AlertType.CONFIRMATION,"Room Added...", ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Please try again...", ButtonType.CLOSE).show();
            }

        }else {
            new Alert(Alert.AlertType.WARNING,"Not available...", ButtonType.CLOSE).show();
        }


    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public boolean isExists(Rooms rooms) {
        for (Rooms t : roomList
        ) {
            if (t.getRoomId().equalsIgnoreCase(rooms.getRoomId())) {
                return false;
            }
        }
        return true;
    }

    public void updateOnAction(ActionEvent actionEvent) {
        Rooms rooms = new Rooms(txtId.getText(),txtType.getText(),txtAvailability.getText(),txtPrice.getText());

        if(isExists(rooms)){

            if(roomList.add(rooms)){
                loadAllRooms();
                new Alert(Alert.AlertType.CONFIRMATION,"Room Added...", ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Please try again...", ButtonType.CLOSE).show();
            }

        }else {
            new Alert(Alert.AlertType.WARNING,"Not available...", ButtonType.CLOSE).show();
        }

    }

    private void loadAllRooms(){
        ObservableList<RoomsTm> tmObservableList = FXCollections.observableArrayList();
        for (Rooms temp:roomList
             ) {
            Button btn = new Button("Delete");
            tmObservableList.add(
                    new RoomsTm(temp.getRoomId(),temp.getRoomType(),temp.getRoomAvailability(),temp.getPrice(),btn)

            );

            btn.setOnAction((e)->{

                ButtonType yes= new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no= new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure Delete Room ? ",yes,no);
                Optional<ButtonType> result = alert.showAndWait();

                if(result.orElse(no)==yes){
                    roomList.remove(temp);
                    loadAllRooms();
                }else {

                }
               // new Alert(Alert.AlertType.CONFIRMATION,"Room Deleted...", ButtonType.CLOSE).show();
            });

        }
        tblRoom.setItems(tmObservableList);
    }

    public void signOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void moveToType(ActionEvent actionEvent) {
        txtType.requestFocus();
    }

    public void moveToPrice(ActionEvent actionEvent) {
        txtPrice.requestFocus();
    }

    public void moveToAvaili(ActionEvent actionEvent) {
        txtAvailability.requestFocus();
    }
}
