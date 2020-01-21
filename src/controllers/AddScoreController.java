package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.*;

import java.io.IOException;
import java.util.ArrayList;

public class AddScoreController {

    Statistics statistics = Statistics.getInstance();
    private static int result;

    @FXML
    public TextField nameField = new TextField();
    @FXML
    public Button addButton;
    @FXML
    public Label scoreLabel = new Label();

    public void addScore() throws IOException{
        if(nameField.getText() != null) {
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
        fxmlLoader.setLocation(getClass().getResource("/views/StatisticsScore.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(){
        scoreLabel.setText(String.valueOf(result));
    }

}


