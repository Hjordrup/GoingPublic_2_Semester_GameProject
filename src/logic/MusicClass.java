package logic;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicClass {

    Media musicFile = new Media("file:///C:/Users/Hjord/OneDrive/Skrivebord/Items/BackgroundMusic.wav");
    MediaPlayer mediaPlayer;
    void playMusic(){
        mediaPlayer = new MediaPlayer(musicFile);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.02);
        mediaPlayer.setOnRepeat(this::playMusic);
    }




}
