package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Statistics implements Initializable {
    private static Statistics instance=null;
    public static Statistics getInstance(){
        instance = new Statistics();
        return instance;
    }

    public TableView<Score> scoreTable = new TableView<Score>();
    public TableColumn<Score,String> nameColumn;
    public TableColumn<Score,Integer> scoreColumn;

    ObservableList<Score> data = FXCollections.observableArrayList(
            new Score("Magda",9)
    );



    public void addScore(Score score){
        scoreTable.getItems().add(score);
    }



    public void draw() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Statystyka");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/statistics.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setWidth(400);
        stage.setHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        scoreTable.setItems(data);
    }
}
