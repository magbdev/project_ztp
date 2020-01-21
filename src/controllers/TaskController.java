
package controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Level;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskController implements Initializable {
    @FXML
    public Label questionLabel = new Label(),answerLabel = new Label();
    @FXML
    public RadioButton a = new RadioButton(),b = new RadioButton(),c = new RadioButton(),d = new RadioButton(),e = new RadioButton();
    @FXML
    public Button nextButton = new Button(),showAnswerButton = new Button();
    @FXML
    public StackPane stackPane = new StackPane();
    @FXML
    public ToggleGroup toggleGroup;

    private Stage stage;
    private static Level level;
    private static int mode;
    public void set(Level level,int mode){
        this.level = level;
        this.mode = mode;
    }


    public void open() throws IOException {
        stage = new Stage();
        stage.setTitle("Pytanie");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/task.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setWidth(400);
        stage.setHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();

    }
    AtomicInteger licznik= new AtomicInteger(0);
    private static int result=0;
    public void setNextButton() throws IOException{
        if(toggleGroup.getSelectedToggle() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Wybierz odpowiedź");
            alert.showAndWait();
        }
        else{
            if(level.isCorrectAnswer(mode,toggleGroup)){
                result++;
                System.out.println(result);
            }
            if(licznik.get() == 4 && mode == 2){
                AddStaticticController addStaticticController = new AddStaticticController();
                addStaticticController.setResult(result);
                addStaticticController.open();
                nextButton.getScene().getWindow().hide();
                result =0;
                licznik.set(0);
            }
            else{
                licznik.getAndIncrement();
                toggleGroup.getSelectedToggle().setSelected(false);
                answerLabel.setText("");
                level.loadQuestion(questionLabel,a,b,c,d,e,answerLabel,showAnswerButton);
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(mode == 1){
            answerLabel.setVisible(true);
            showAnswerButton.setVisible(true);
        }
        level.loadQuestion(questionLabel,a,b,c,d,e,answerLabel,showAnswerButton);
    }
}