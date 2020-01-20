package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.*;

import java.io.IOException;
import java.util.ArrayList;

public class AddScoreController {


    ArrayList<Score> listStatistics;


    public void setListStatistics(ArrayList<Score> listQuestion) {
        this.listStatistics = listStatistics;
    }

    public ArrayList<Score> getListStatistics() {
        return listStatistics;
    }

    @FXML
    public TextField nameField = new TextField();
    @FXML
    public Button addScoreButton;
    @FXML
    public Label Name, Score;

    private static int result = 0;


    public void addScore() {
        Score score = new Score(nameField.getText(), result);
        listStatistics.add(score);
        Score score1 = new Score("Beata", 5);
        listStatistics.add(score1);
        ScoreBaseList list = new ScoreBaseList();
        listStatistics = list.getStatistics();
        listStatistics.add(score);
        list.saveStatistics(listStatistics);
    }

    Score score = new Score("df", 3);

    public void setScore() {

        Name.setText(score.getName());
        Score.setText(String.valueOf(score.getScore()));
    }

    public void setResult(int result) {
        AddScoreController.result = result;
    }

    public void open() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Statystyka");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/StatisticsScore.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }


}








