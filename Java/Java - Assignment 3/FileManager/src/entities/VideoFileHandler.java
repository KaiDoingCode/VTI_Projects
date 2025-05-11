package entities;

import interfaces.Compressible;
import interfaces.Encryptable;

public class VideoFileHandler extends FileHandler implements Compressible, Encryptable {

    public VideoFileHandler(String fileName) {
        super(fileName);
    }

    @Override
    public void read() {
        System.out.println("Playing video: " + fileName);
    }

    @Override
    public void write() {
        System.out.println("Editing video: " + fileName);
    }

    @Override
    public void delete() {
        System.out.println("Deleting video: " + fileName);
    }

    @Override
    public void compress() {
        System.out.println("Compressing video: " + fileName);
    }

    @Override
    public void encrypt() {
        System.out.println("Encrypting video: " + fileName);
    }
}
