package controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Score;
import models.Statistics;

import java.io.IOException;

public class MainWindowController extends Application {

    @FXML
    private Button adventureButton,testButton,statisticButton,addQuestionButton,editQuestionButton,deleteQuestionButton,addAnswerButton,editAnswerButton,deleteAnswerButton;

    public Statistics s = Statistics.getInstance();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/mainWindow.fxml"));
        stage.setTitle("QUIZ");
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setWidth(400);
        stage.setHeight(350);
        stage.setScene(scene);
        stage.show();
    }
    public void openStatistics() throws IOException {
        s.draw();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

