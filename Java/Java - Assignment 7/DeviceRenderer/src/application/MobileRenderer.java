package application;

import domain.Document;

public class MobileRenderer extends DeviceRenderer {

    public MobileRenderer(Document document) {
        super(document);
    }

    @Override
    public void display() {
        System.out.println("Rendering on Mobile:");
        System.out.println("Type: " + document.getType());
        System.out.println("Content: " + document.getContent().toUpperCase()); // simulate mobile-style
    }
}

