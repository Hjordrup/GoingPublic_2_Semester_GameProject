package logic;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicClass {

    Media backgroundMusic = new Media("file:///C:/Users/Hjord/OneDrive/Skrivebord/Items/BackgroundMusic.wav");
    Media buy = new Media("file:///C:/Users/Hjord/OneDrive/Skrivebord/Items/BuySound.wav");



    MediaPlayer mediaPlayer;
    void playMusic(){
        mediaPlayer = new MediaPlayer(backgroundMusic);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.02);
        mediaPlayer.setOnRepeat(this::playMusic);
    }



    void playBuySound(){

        mediaPlayer = new MediaPlayer(buy);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.02);
    }


}
