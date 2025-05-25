package application;

import domain.Document;

public class RealDocument implements Document {
    private String filename;

    public RealDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("Reading contents of: " + filename);
    }
}
