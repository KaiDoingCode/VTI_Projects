import application.DocumentProxy;
import domain.Document;

public class Main {
    public static void main(String[] args) {
        Document adminDoc = new DocumentProxy("confidential.txt", "admin");
        Document guestDoc = new DocumentProxy("confidential.txt", "guest");

        System.out.println("Admin access:");
        adminDoc.read();

        System.out.println("\nGuest access:");
        guestDoc.read();
    }
}
