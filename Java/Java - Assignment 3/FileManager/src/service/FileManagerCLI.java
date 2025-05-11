package service;

import entities.*;
import interfaces.*;

import java.util.Scanner;

public class FileManagerCLI {
    private Scanner scanner = new Scanner(System.in);
    private FileHandler file;

    public void start() {
        System.out.println("Choose file type (1=Text, 2=Image, 3=Video):");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        switch (choice) {
            case 1 -> file = new TextFileHandler(fileName);
            case 2 -> file = new ImageFileHandler(fileName);
            case 3 -> file = new VideoFileHandler(fileName);
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        handleCommands();
    }

    private void handleCommands() {
        while (true) {
            System.out.println("\nChoose action: read, write, delete, compress, encrypt, exit");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "read" -> file.read();
                case "write" -> file.write();
                case "delete" -> file.delete();
                case "compress" -> {
                    if (file instanceof Compressible compressible) {
                        compressible.compress();
                    } else {
                        System.out.println("This file type cannot be compressed.");
                    }
                }
                case "encrypt" -> {
                    if (file instanceof Encryptable encryptable) {
                        encryptable.encrypt();
                    } else {
                        System.out.println("This file type cannot be encrypted.");
                    }
                }
                case "exit" -> {
                    System.out.println("Exiting file manager.");
                    return;
                }
                default -> System.out.println("Unknown command.");
            }
        }
    }
}
