package controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Statistics;

import java.io.IOException;

public class MainWindowController extends Application {


    @FXML
    private Button adventureButton,testButton,statisticButton,addQuestionButton,editQuestionButton,deleteQuestionButton,addAnswerButton,editAnswerButton,deleteAnswerButton,addScoreButton;

    public Statistics s = Statistics.getInstance();
    public AddQuestionController addQuestionController = new AddQuestionController();
    public ModeController modeController = new ModeController();
    public EditQuestionController editQuestionController = new EditQuestionController();
    public DeleteQuestionController deleteQuestionController = new DeleteQuestionController();
    public AddAnswerController addAnswerController = new AddAnswerController();
    public EditAnswerController editAnswerController = new EditAnswerController();
    public DeleteAnswerController deleteAnswerController = new DeleteAnswerController();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/mainWindow.fxml"));
        stage.setTitle("QUIZ");
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setWidth(600);
        stage.setHeight(500);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }
    public void openStatistics() throws IOException {
        s.draw();

    }
    public void addQuestion() throws IOException{
        addQuestionController.open();
    }

    public void adventure() throws IOException{
        modeController.open();
        modeController.setMode(1);
    }

    public void test() throws IOException{
        modeController.open();
        modeController.setMode(2);
    }

    public void editQuestion() throws IOException{
        editQuestionController.open();
    }

    public void deleteQuestion() throws IOException{
        deleteQuestionController.open();
    }

    public void addAnswer() throws IOException{
        addAnswerController.open();
    }

    public void editAnswer() throws IOException{
        editAnswerController.open();
    }

    public void deleteAnswer() throws IOException{
        deleteAnswerController.open();
    }

    public static void main(String[] args) {
        launch(args);

    }


}