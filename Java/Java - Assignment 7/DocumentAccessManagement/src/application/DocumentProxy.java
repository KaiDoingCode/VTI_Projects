package application;

import domain.Document;

public class DocumentProxy implements Document {
    private String filename;
    private String userRole;
    private RealDocument realDocument;

    public DocumentProxy(String filename, String userRole) {
        this.filename = filename;
        this.userRole = userRole;
    }

    @Override
    public void read() {
        if ("admin".equalsIgnoreCase(userRole)) {
            if (realDocument == null) {
                realDocument = new RealDocument(filename);
            }
            realDocument.read();
        } else {
            System.out.println("Access denied. Only admin can read this document.");
        }
    }
}
