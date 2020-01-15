package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Answer;
import models.QuestionBaseList;


import java.io.IOException;
import java.util.ArrayList;

public class AddAnswerController {
    @FXML
    private TextField answerField = new TextField();
    @FXML
    private Button addButton;

    QuestionBaseList baseList = new QuestionBaseList();
    ArrayList<Answer> list = baseList.getAnswers();

    public void open() throws IOException{
        Stage stage = new Stage();
        stage.setTitle("Dodaj słówko");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/addAnswer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setWidth(400);
        stage.setHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public void addAnswer(){
        Answer a = new Answer();
        a.setAnswer(answerField.getText());
        list.add(a);
        baseList.saveAnswers(list);
    }
}
