package application;

import domain.EmailSender;

public class EncryptionDecorator extends EmailDecorator {
    public EncryptionDecorator(EmailSender wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        String encrypted = "[Encrypted] " + message;
        super.send(encrypted);
    }
}
