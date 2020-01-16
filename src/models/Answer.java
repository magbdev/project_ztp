package models;

import java.io.Serializable;

public class Answer implements Serializable {
    static final long serialVersionUID = 319068444728581721L;
    private String answer;

    public Answer(String answer) {
        this.answer = answer;
    }

    public Answer() {

    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }


}
