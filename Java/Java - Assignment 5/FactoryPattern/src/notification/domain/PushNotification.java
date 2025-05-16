package notification.domain;

public class PushNotification implements Notification {
    public void send() {
        System.out.println("Sending Push Notification");
    }
}
