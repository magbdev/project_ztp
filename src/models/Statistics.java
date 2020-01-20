
package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


public class Statistics {
    private static Statistics instance = new Statistics();
    public static Statistics getInstance(){
        // if(instance == null) {
        //   instance = new Statistics();
        //}
        return instance;
    }

    @FXML
    public ListView<Score> listView;


    ScoreBaseList scoreBaseList = new ScoreBaseList();
    ArrayList<Score> listStatistics = scoreBaseList.getStatistics();

    private ObservableList<Score> data = FXCollections.observableArrayList(listStatistics);

    /*public void setResult(int result){
        Statistics.result =result;
    }*/

    public void addScore(String name, int result){
        Score score = new Score(name,result);
        data.add(score);
        listStatistics.add(score);
        scoreBaseList.saveStatistics(listStatistics);

    }

    public void draw() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Statystyka");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/statistics.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }



    public void initialize() {
        listView.setItems(data);
    }

}