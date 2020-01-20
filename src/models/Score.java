package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Score implements Serializable {
    static final long serialVersionUID = 7445835812753532432L;
    private SimpleStringProperty name;
    private SimpleIntegerProperty score;

    public Score(String name,int score){
        this.name = new SimpleStringProperty(name);
        this.score = new SimpleIntegerProperty(score);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public int getScore() {
        return score.get();
    }

    public void setScore(int score) {
        this.score = new SimpleIntegerProperty(score);
    }
}
