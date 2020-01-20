package models;

import java.io.*;
import java.util.ArrayList;


public class ScoreBaseList {
    private ArrayList<Score> score;

    public ArrayList<Score> getStatistics() {
        try {
            FileInputStream fis = new FileInputStream("listStatistics");
            ObjectInputStream ois = new ObjectInputStream(fis);

            score = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (
                IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }
        return score;
    }


    public void saveStatistics(ArrayList<Score> listStatistics) {
        try {
            FileOutputStream fos = new FileOutputStream("listStatistics");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listStatistics);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
