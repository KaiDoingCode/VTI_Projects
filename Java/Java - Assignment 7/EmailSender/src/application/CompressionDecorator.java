package application;

import domain.EmailSender;

public class CompressionDecorator extends EmailDecorator {
    public CompressionDecorator(EmailSender wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        String compressed = "[Compressed] " + message;
        super.send(compressed);
    }
}

