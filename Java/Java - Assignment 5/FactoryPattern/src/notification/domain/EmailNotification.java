package notification.domain;

public class EmailNotification implements Notification {
    public void send() {
        System.out.println("Sending Email Notification");
    }
}
