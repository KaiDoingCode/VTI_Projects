package entities;

import interfaces.Compressible;

public class ImageFileHandler extends FileHandler implements Compressible {

    public ImageFileHandler(String fileName) {
        super(fileName);
    }

    @Override
    public void read() {
        System.out.println("Viewing image: " + fileName);
    }

    @Override
    public void write() {
        System.out.println("Editing image: " + fileName);
    }

    @Override
    public void delete() {
        System.out.println("Deleting image: " + fileName);
    }

    @Override
    public void compress() {
        System.out.println("Compressing image: " + fileName);
    }
}
