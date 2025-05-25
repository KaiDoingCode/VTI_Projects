import application.*;
import domain.TV;

public class Main {
    public static void main(String[] args) {
        TV samsung = new SamsungTV();
        RemoteControl samsungRemote = new BasicRemoteControl(samsung);
        samsungRemote.turnOn();
        samsungRemote.changeChannel(5);
        samsungRemote.turnOff();

        System.out.println();

        TV sony = new SonyTV();
        RemoteControl sonyRemote = new BasicRemoteControl(sony);
        sonyRemote.turnOn();
        sonyRemote.changeChannel(10);
        sonyRemote.turnOff();
    }
}
