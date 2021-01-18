package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Player;


public class MainGameViewController extends Application {





    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../view/MainGamePage.fxml"));

        primaryStage.setTitle("Going Public V.0.1 Pre-Alpha");
        primaryStage.setScene(new Scene(root,1600,900));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}