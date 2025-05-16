package notification.domain;

public class SMSNotification implements Notification {
    public void send() {
        System.out.println("Sending SMS Notification");
    }
}
