package models;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public interface Level {
    RandomQuestionIterator iterator = new RandomQuestionIterator(new QuestionBaseList());
    RandomAnswerIterator answerIterator = new RandomAnswerIterator(new QuestionBaseList());
    void loadQuestion(Label q, RadioButton a, RadioButton b, RadioButton c, RadioButton d, RadioButton e, Label answer, Button show);
    boolean isCorrectAnswer(int mode,ToggleGroup toggleGroup);
}
