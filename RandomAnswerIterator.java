package models;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomAnswerIterator implements Iterator {

    private List<Answer> answers;
    public RandomAnswerIterator(QuestionBaseList baseList){
        this.answers = baseList.getAnswers();
    }

    private Random random = new Random();

    @Override
    public boolean hasNext() {
        return true;
    }
    public Answer next(){
        return answers.get(random.nextInt(answers.size()));
    }
}
