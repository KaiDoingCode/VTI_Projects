package facade;

import application.*;

public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(String movie) {
        System.out.println("\nGetting ready to watch a movie...");
        projector.on();
        projector.setInput("DVD");

        soundSystem.on();
        soundSystem.setVolume(7);

        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("\nShutting down home theater...");
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
    }
}
