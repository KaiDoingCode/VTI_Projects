package application;

import domain.EmailSender;

public abstract class EmailDecorator implements EmailSender {
    protected EmailSender wrapped;

    public EmailDecorator(EmailSender wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send(String message) {
        wrapped.send(message);
    }
}

