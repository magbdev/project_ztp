package models;

import java.io.*;
import java.util.ArrayList;


public class QuestionBaseList {
    private ArrayList<Question> questions;
    private ArrayList<Answer> answers;

    public ArrayList<Question> getQuestions(){
        try {
            FileInputStream fis = new FileInputStream("listQuestion");
            ObjectInputStream ois = new ObjectInputStream(fis);

            questions = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (
                IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }
        return questions;
    }
    public void saveQuestions(ArrayList<Question> listQuestion){
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
    public ArrayList<Answer> getAnswers(){
        try {
            FileInputStream fis = new FileInputStream("listAnswer");
            ObjectInputStream ois = new ObjectInputStream(fis);

            answers = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }
        return answers;
    }

    public void saveAnswers(ArrayList<Answer> listAnswer){
        try {
            FileOutputStream fos = new FileOutputStream("listAnswer");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listAnswer);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
