
package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Statistics {
    private static Statistics instance = new Statistics();
    public static Statistics getInstance(){
        // if(instance == null) {
        //   instance = new Statistics();
        //}
        return instance;
    }
    @FXML
    public TextField nameField = new TextField();
    @FXML
    public Button addScoreButton;

    private static int result = 0;

    public TableView<Score> scoreTable = new TableView<Score>();
    public TableColumn<Score,String> nameColumn = new TableColumn<>("Imię");
    public TableColumn<Score,Integer> scoreColumn = new TableColumn<>("Wynik");

    private ObservableList<Score> data = FXCollections.observableArrayList(
            new Score("name",3)
    );

    public void setResult(int result){
        Statistics.result =result;
    }

    public void addScore(){
        Score score = new Score(nameField.getText(),result);
        data.add(score);
        scoreTable.setItems(data);
        scoreTable.refresh();
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
        scoreTable.setEditable(true);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        scoreTable.getColumns().addAll(nameColumn,scoreColumn);
        scoreTable.setItems(data);
        scoreTable.refresh();
    }

}