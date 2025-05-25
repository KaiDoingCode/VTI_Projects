package main;

import application.NewAudioPlayer;
import domain.MediaPlayer;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new NewAudioPlayer();
        player.play("mp3", "classic.mp3");
        player.play("mp4", "video.mp4");
        player.play("vlc", "movie.vlc");
        player.play("avi", "unknown.avi");
    }
}
