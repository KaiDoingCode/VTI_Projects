package application;

import domain.Document;

public abstract class DeviceRenderer {
    protected Document document;

    public DeviceRenderer(Document document) {
        this.document = document;
    }

    public abstract void display();
}
