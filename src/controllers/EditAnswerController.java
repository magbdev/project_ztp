package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Answer;
import models.Question;
import models.QuestionBaseList;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class EditAnswerController implements Initializable {
    @FXML
    private TextField answerField = new TextField();
    @FXML
    private Button saveButton,nextButton;

    QuestionBaseList baseList = new QuestionBaseList();
    ArrayList<Answer> listAnswers = baseList.getAnswers();
    Iterator<Answer> iterator = listAnswers.iterator();
    Answer a;
    public void open() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Edytuj słówko");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/editAnswer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setWidth(400);
        stage.setHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }
    public void setAnswer(){
        if(iterator.hasNext()) {
            a = iterator.next();
            answerField.setText(a.getAnswer());
        }
    }

    public void save(){
        a.setAnswer(answerField.getText());
        baseList.saveAnswers(listAnswers);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setAnswer();
    }
}
