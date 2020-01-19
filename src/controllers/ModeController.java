package controllers;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Level1;
import models.Level2;
import models.Level3;

import java.io.IOException;

public class ModeController {

    private static int mode;
    public void setMode(int mode){
        this.mode = mode;
    }
    @FXML
    private Button level1Button,level2Button,level3Button;
    private TaskController task = new TaskController();
    public void setLevel1Button() throws IOException {
        task.set(new Level1(),mode);
        task.open();
    }
    public void setLevel2Button() throws IOException{
        task.set(new Level2(),mode);
        task.open();
    }
    public void setLevel3Button() throws IOException{
        task.set(new Level3(),mode);
        task.open();
    }
    public void open() throws IOException{
        Stage stage = new Stage();
        stage.setTitle("Poziomy");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/mode.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setWidth(400);
        stage.setHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}
