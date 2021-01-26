package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;


public class MainGameViewController extends Application {
    Parent root;
    Parent root1;
    Stage window;

    @FXML
    private AnchorPane creditsPane;
    @FXML
    private Button closeCreditsButton;


    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
        window.setTitle("Going Public V.0.3 Pre-Alpha");
        Scene s1 = new Scene(root);
        window.setScene(s1);
        window.setResizable(false);
        window.show();
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

    @FXML
    void closeCredits() {
    creditsPane.setVisible(false);
    }

    @FXML
    void openCredits() {
        creditsPane.setVisible(true);
    }


}

