package models;

import java.io.Serializable;

public class Question implements Serializable  {

    static final long serialVersionUID = 7445835812753532432L;
    private String question;
    private String correctAnswer;

    public Question(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public Question() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


}
