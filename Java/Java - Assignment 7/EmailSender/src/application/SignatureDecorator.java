package application;

import domain.EmailSender;

public class SignatureDecorator extends EmailDecorator {
    public SignatureDecorator(EmailSender wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        String signed = message + " [Signed]";
        super.send(signed);
    }
}
