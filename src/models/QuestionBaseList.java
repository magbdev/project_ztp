package models;

import java.util.List;

public class QuestionBaseList {
    private List<Question> questions;
    private List<Answer> answers;

    public List<Question> getQuestions(){
        return questions;
    }
    public List<Answer> getAnswers(){
        return answers;
    }
}
