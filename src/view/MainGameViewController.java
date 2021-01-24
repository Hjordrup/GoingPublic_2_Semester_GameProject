package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class MainGameViewController extends Application {
    Parent root;
    Parent root1;
    Stage primaryStage;

    @Override
    public void start(Stage primary) throws Exception{


        primaryStage = primary;
        root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
        primaryStage.setTitle("Going Public V.0.3 Pre-Alpha");
        Scene s1 = new Scene(root);
        primaryStage.setScene(s1);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void setNewGameButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/IntroToGame.fxml"));
        root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Going Public V.0.3 Pre-Alpha");
        stage.setScene(new Scene(root1));
        stage.show();



    }

    public void continueToGame(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MainGamePage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Going Public V.0.3 Pre-Alpha");
        stage.setScene(new Scene(root1,1600,900));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

