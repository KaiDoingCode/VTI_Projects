import shape.ShapeDemo;
import notification.NotificationDemo;
import registryfactory.RegistryDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Shape Factory Demo ===");
        ShapeDemo.run();

        System.out.println("\n=== Notification Factory Demo ===");
        NotificationDemo.run();

        System.out.println("\n=== Registry Factory Demo ===");
        RegistryDemo.run();
    }
}
