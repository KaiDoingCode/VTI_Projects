package notification;

import notification.domain.Notification;
import notification.domain.NotificationFactory;

public class NotificationDemo {
    public static void run() {
        Notification n1 = NotificationFactory.createNotification("email");
        n1.send();

        Notification n2 = NotificationFactory.createNotification("sms");
        n2.send();
    }
}
