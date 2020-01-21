package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Score implements Serializable {
    static final long serialVersionUID = 7445835812753532432L;
    private String name;
    private Integer score;

    public Score(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
public Score()
{

}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}