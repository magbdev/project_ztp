package controllers;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Level;
import models.Statistics;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskController {
    @FXML
    public Label questionLabel;
    @FXML
    public RadioButton a,b,c,d,e;
    @FXML
    public Button nextButton;
    @FXML
    public StackPane stackPane;

    private Level level;
    private int mode;
    public void set(Level level,int mode){
        this.level = level;
        this.mode = mode;
    }


    public void open() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Pytanie");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/task.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setWidth(400);
        stage.setHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);
        if(mode==1){
            adventureMode();
        }
        else if(mode==2){
            testMode();
        }
        stage.setScene(scene);
        stage.show();

    }
    private void adventureMode(){
        Button showAnswerButton = new Button("Pokaz");
        Label answerLabel = new Label("Odpowiedz");
        stackPane.getChildren().addAll(showAnswerButton,answerLabel);
        level.loadQuestion(questionLabel,a,b,c,d,e,answerLabel,showAnswerButton);
        nextButton.setOnAction(actionEvent -> {
            level.loadQuestion(questionLabel,a,b,c,d,e,answerLabel,showAnswerButton);
        });
    }
    AtomicInteger licznik= new AtomicInteger(0);
    private int result=0;
    private void testMode() throws IOException {
        if(licznik.get() == 4){
            Statistics.getInstance().draw();
        }
        else{
            nextButton.setOnAction(actionEvent -> {
                level.loadQuestion(questionLabel, a, b, c, d, e, null, null);
                licznik.getAndIncrement();
            });

        }


    }


}
