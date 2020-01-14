package models;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import java.util.Random;

public class Level1 implements Level {

    @Override
    public void loadQuestion(Label q, RadioButton a, RadioButton b, RadioButton c, RadioButton d, RadioButton e, Label answer, Button show) {
        RandomQuestionIterator iterator = new RandomQuestionIterator(new QuestionBaseList());
        RandomAnswerIterator answerIterator = new RandomAnswerIterator(new QuestionBaseList());
        Question question = iterator.next();
        q.setText(question.getQuestion());
        d.setVisible(false);
        e.setVisible(false);
        Random r = new Random();
        int random = r.nextInt(3);
        if(random == 1){
            a.setText(question.getCorrectAnswer());
        }
        else{
            a.setText(answerIterator.next().getAnswer());
        }
        if(random == 2){
            b.setText(question.getCorrectAnswer());
        }
        else{
            b.setText(answerIterator.next().getAnswer());
        }
        if(random == 3){
            c.setText(question.getCorrectAnswer());
        }
        else{
            c.setText(answerIterator.next().getAnswer());
        }
        if(show != null && answer != null){
            show.setOnAction(actionEvent -> {
                answer.setText(question.getCorrectAnswer());
            });
        }
    }
}
