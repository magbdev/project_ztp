package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Question;
import models.QuestionBaseList;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;


public class DeleteQuestionController implements Initializable {
    @FXML
    private Label questionLabel,answerLabel;
    @FXML
    private Button deleteButton,nextButton;

    QuestionBaseList baseList = new QuestionBaseList();
    ArrayList<Question> list = baseList.getQuestions();
    Iterator<Question> iterator = list.iterator();
    Question q;

    public void open() throws IOException{
        Stage stage = new Stage();
        stage.setTitle("Usuń pytanie");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/deleteQuestion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setWidth(400);
        stage.setHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    public void setQuestion(){
        if(iterator.hasNext()) {
            q = iterator.next();
            questionLabel.setText(q.getQuestion());
            answerLabel.setText(q.getCorrectAnswer());
        }
        else{
            nextButton.getScene().getWindow().hide();
        }
    }

    public void delete(){
        iterator.remove();
        baseList.saveQuestions(list);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Odpowiedź została usunięta");
        alert.showAndWait();
        setQuestion();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setQuestion();
    }
}
