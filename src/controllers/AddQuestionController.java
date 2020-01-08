package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Question;
import models.QuestionBaseList;

import java.io.*;
import java.util.ArrayList;

public class AddQuestionController {


    @FXML
    private TextField questionField, answerField;
    @FXML
    private Button addButton;

    ArrayList<Question> listQuestion = new ArrayList<>();

    public void setListQuestion(ArrayList<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    public ArrayList<Question> getListQuestion() {
        return listQuestion;
    }



    public void addQuestion() {

        try {
            FileInputStream fis = new FileInputStream("listQuestion");
            ObjectInputStream ois = new ObjectInputStream(fis);

            listQuestion = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }


        Question q = new Question();
        q.setQuestion(questionField.getText());
        q.setCorrectAnswer(answerField.getText());
        listQuestion.add(q);
        //    new QuestionBaseList().getQuestions().add(q);
        saveQuestion();
    }

    private void saveQuestion () {
        try {
            FileOutputStream fos = new FileOutputStream("listQuestion");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listQuestion);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }




}
