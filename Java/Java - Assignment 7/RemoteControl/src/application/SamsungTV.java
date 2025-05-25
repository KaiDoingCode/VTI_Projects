package application;

import domain.TV;

public class SamsungTV implements TV {
    @Override
    public void on() {
        System.out.println("Samsung TV is ON");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV is OFF");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Samsung TV: Channel set to " + channel);
    }
}
