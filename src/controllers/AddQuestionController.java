package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Question;
import models.QuestionBaseList;

public class AddQuestionController {

    @FXML
    private TextField questionField,answerField;
    @FXML
    private Button addButton;

    public void addQuestion(){
        Question q = new Question();
        q.setQuestion(questionField.getText());
        q.setCorrectAnswer(answerField.getText());
        new QuestionBaseList().getQuestions().add(q);
    }
}
