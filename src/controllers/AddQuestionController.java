package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Question;
import models.QuestionBaseList;

import java.io.*;
import java.util.ArrayList;

public class AddQuestionController {


    @FXML
    private TextField questionField, answerField;
    @FXML
    private Button addButton;

    ArrayList<Question> listQuestion;

    public void setListQuestion(ArrayList<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    public ArrayList<Question> getListQuestion() {
        return listQuestion;
    }

    public void open() throws IOException{
        Stage stage = new Stage();
        stage.setTitle("Dodaj pytanie");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/addQuestion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setWidth(400);
        stage.setHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    public void addQuestion() {

        Question q = new Question();
        q.setQuestion(questionField.getText());
        q.setCorrectAnswer(answerField.getText());
        QuestionBaseList list = new QuestionBaseList();
        listQuestion = list.getQuestions();
        listQuestion.add(q);
        list.saveQuestions(listQuestion);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Odpowiedź została dodana");
        alert.showAndWait();
        addButton.getScene().getWindow().hide();

    }



}
