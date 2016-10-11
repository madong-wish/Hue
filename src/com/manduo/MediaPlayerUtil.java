package com.manduo;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;

/**
 * Created by manduo
 * dong on 10/9/16.
 */

public class MediaPlayerUtil extends Application {
    private static String dataType;
    private static String source;

    void play(String type, String src) {
        dataType = type;
        source = src;
        launch();
    }
    void playMusic() {
        //System.out.println("DataType: " + dataType);
        Media media;
        if (dataType.equals("File")) {
            media = new Media(Paths.get(source).toUri().toString());
        }
        else {
            media = new Media(source);
        }
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    @Override
    public void start(Stage stage) throws Exception {
        playMusic();
    }
}
