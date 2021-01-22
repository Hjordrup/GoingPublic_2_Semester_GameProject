package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class MainGameViewController extends Application {
    @FXML
    private Label newGameButton;

    @FXML
    private Label ContinueButton;

    @FXML
    private Label CreditsButton;
    Parent root;
    Stage primaryStage;

    @Override
    public void start(Stage primary) throws Exception{
        this.primaryStage = primary;
        root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
        primaryStage.setTitle("Going Public V.0.3 Pre-Alpha");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void setNewGameButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/IntroToGame.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
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

