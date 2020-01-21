package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Question;
import models.QuestionBaseList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class EditQuestionController implements Initializable {
    @FXML
    private TextField questionField = new TextField(), answerField = new TextField();
    @FXML
    private Button saveButton, nextButton;

    QuestionBaseList baseList = new QuestionBaseList();
    ArrayList<Question> list = baseList.getQuestions();
    Iterator<Question> iterator = list.iterator();
    Question q;

    public void open() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Edytuj pytanie");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/editQuestion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setWidth(400);
        stage.setHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();

    }


    public void setQuestion() {
        if (iterator.hasNext()) {
            q = iterator.next();
            questionField.setText(q.getQuestion());
            answerField.setText(q.getCorrectAnswer());
        }

    }

    public void save() {
        q.setQuestion(questionField.getText());
        q.setCorrectAnswer(answerField.getText());
        baseList.saveQuestions(list);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Odpowiedź została zapisana");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setQuestion();
    }
}
