import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String logFile = "application.log";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile))) {
            writer.write("2025-05-14 10:00:01 INFO Server started successfully\n");
            writer.write("2025-05-14 10:00:02 ERROR Database connection failed\n");
            writer.write("2025-05-14 10:00:03 WARN Low memory warning\n");
            writer.write("2025-05-14 10:00:04 INFO User admin logged in\n");
            writer.write("2025-05-14 10:00:05 ERROR Unable to reach server\n");
            writer.write("2025-05-14 10:00:06 INFO Server shutdown initiated\n");
            System.out.println("Sample log file created.");
        } catch (IOException e) {
            System.err.println("Error creating log file: " + e.getMessage());
            return;
        }

        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the log file: " + e.getMessage());
            return;
        }

        String outputFile = "keyword_frequency.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Keyword frequency written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing output file: " + e.getMessage());
        }

        System.out.println("\n--- Keyword Frequencies ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading result file: " + e.getMessage());
        }
    }
}
