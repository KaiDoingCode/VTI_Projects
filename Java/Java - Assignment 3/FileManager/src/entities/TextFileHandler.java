package entities;

import interfaces.Encryptable;

public class TextFileHandler extends FileHandler implements Encryptable {

    public TextFileHandler(String fileName) {
        super(fileName);
    }

    @Override
    public void read() {
        System.out.println("Reading text file: " + fileName);
    }

    @Override
    public void write() {
        System.out.println("Writing to text file: " + fileName);
    }

    @Override
    public void delete() {
        System.out.println("Deleting text file: " + fileName);
    }

    @Override
    public void encrypt() {
        System.out.println("Encrypting text file: " + fileName);
    }
}
