package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.*;

import java.io.IOException;

public class AddStaticticController {

    Statistics statistics = Statistics.getInstance();
    private static int result;

    @FXML
    public TextField nameField = new TextField();
    @FXML
    public Button addButton;
    @FXML
    public Label scoreLabel = new Label();

    public void addScore() throws IOException{
        if(!nameField.getText().equals("")) {
            statistics.addScore(nameField.getText(), result);
            addButton.getScene().getWindow().hide();
            statistics.draw();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Wpisz imię");
            alert.showAndWait();
        }
    }

    public void setResult(int result){
        this.result = result;
    }


    public void open() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Statystyka");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/addStatistic.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(){
        scoreLabel.setText(String.valueOf(result));
    }

}


