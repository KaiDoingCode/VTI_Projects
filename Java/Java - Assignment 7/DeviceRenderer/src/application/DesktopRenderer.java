package application;

import domain.Document;

public class DesktopRenderer extends DeviceRenderer {

    public DesktopRenderer(Document document) {
        super(document);
    }

    @Override
    public void display() {
        System.out.println("Rendering on Desktop:");
        System.out.println("Type: " + document.getType());
        System.out.println("Content: " + document.getContent());
    }
}

