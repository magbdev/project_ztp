package models;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomQuestionIterator implements Iterator {

    private List<Question> questions;
    public RandomQuestionIterator(QuestionBaseList baseList){
        this.questions = baseList.getQuestions();
    }
    private Random random = new Random();
    @Override
    public boolean hasNext() {
        return true;
    }
    public Question next(){
        return questions.get(random.nextInt(questions.size()));
    }
}
