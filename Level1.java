package models;

import controllers.TaskController;
import javafx.scene.control.*;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Level1 implements Level {

    private Question question;
    @Override
    public void loadQuestion(Label q, RadioButton a, RadioButton b, RadioButton c, RadioButton d, RadioButton e, Label answer, Button show) {
        question = iterator.next();
        q.setText(question.getQuestion());
        d.setVisible(false);
        e.setVisible(false);
        Random r = new Random();
        int random = r.nextInt(3);
        if(random == 0){
            a.setText(question.getCorrectAnswer());
        }
        else{
            a.setText(answerIterator.next().getAnswer());
        }
        if(random == 1){
            b.setText(question.getCorrectAnswer());
        }
        else{
            b.setText(answerIterator.next().getAnswer());
        }
        if(random == 2){
            c.setText(question.getCorrectAnswer());
        }
        else{
            c.setText(answerIterator.next().getAnswer());
        }
        show.setOnAction(actionEvent -> {
            answer.setText(question.getCorrectAnswer());
        });


    }
    public boolean isCorrectAnswer(int mode,ToggleGroup toggleGroup){
        if(mode == 2){
            RadioButton selected = (RadioButton) toggleGroup.getSelectedToggle();
            String value = selected.getText();
            if (value.equals(question.getCorrectAnswer())) {
                return true;
            }
        }
        return false;
    }
}
