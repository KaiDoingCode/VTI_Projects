package application;

import domain.TV;

public class SonyTV implements TV {
    @Override
    public void on() {
        System.out.println("Sony TV is ON");
    }

    @Override
    public void off() {
        System.out.println("Sony TV is OFF");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Sony TV: Channel set to " + channel);
    }
}
