import gui.Application;
import gui.domain.GUIFactory;
import windows.domain.WindowsFactory;
import mac.domain.MacFactory;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        String os = "windows";

        if (os.equalsIgnoreCase("windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Application app = new Application(factory);
        app.run();
    }
}
