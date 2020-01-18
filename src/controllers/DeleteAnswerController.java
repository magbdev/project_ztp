package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Answer;
import models.QuestionBaseList;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class DeleteAnswerController implements Initializable {

    @FXML
    private Label answerLabel;
    @FXML
    private Button nextButton,deleteButton;

    QuestionBaseList baseList = new QuestionBaseList();
    ArrayList<Answer> listAnswers = baseList.getAnswers();
    Iterator<Answer> iteratorAnswer = listAnswers.iterator();
    Answer a;

    public void open() throws IOException{
        Stage stage = new Stage();
        stage.setTitle("Usuń słówko");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/deleteAnswer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setWidth(400);
        stage.setHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public void setAnswer(){
        if(iteratorAnswer.hasNext()) {
            a = iteratorAnswer.next();
            answerLabel.setText(a.getAnswer());
        }
    }

    public void delete(){
        iteratorAnswer.remove();
        baseList.saveAnswers(listAnswers);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setAnswer();
    }
}
