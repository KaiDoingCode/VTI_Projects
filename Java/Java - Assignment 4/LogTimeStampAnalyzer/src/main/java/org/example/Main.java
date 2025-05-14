package org.example;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String logFile = "server.log";
        String reportFile = "log_report.txt";

        generateSampleLogFile(logFile);

        int infoCount = 0, errorCount = 0, warnCount = 0;
        List<Long> infoTimestamps = new ArrayList<>();
        List<Long> errorTimestamps = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 3);
                if (parts.length < 3) continue;

                String timestampStr = parts[0] + " " + parts[1];
                String level = parts[2].split(" ")[0];

                Date timestamp = sdf.parse(timestampStr);
                long timeMillis = timestamp.getTime();

                switch (level) {
                    case "INFO":
                        infoCount++;
                        infoTimestamps.add(timeMillis);
                        break;
                    case "ERROR":
                        errorCount++;
                        errorTimestamps.add(timeMillis);
                        break;
                    case "WARN":
                        warnCount++;
                        break;
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error processing log: " + e.getMessage());
            return;
        }

        long avgInfoInterval = computeAverageInterval(infoTimestamps);
        long avgErrorInterval = computeAverageInterval(errorTimestamps);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {
            writer.write("Log Statistics Report\n");
            writer.write("=====================\n");
            writer.write("INFO count: " + infoCount + "\n");
            writer.write("ERROR count: " + errorCount + "\n");
            writer.write("WARN count: " + warnCount + "\n\n");
            writer.write("Average time between INFO events: " + avgInfoInterval / 1000 + " seconds\n");
            writer.write("Average time between ERROR events: " + avgErrorInterval / 1000 + " seconds\n");
        } catch (IOException e) {
            System.err.println("Error writing report: " + e.getMessage());
        }

        System.out.println("Report written to " + reportFile);
    }

    private static long computeAverageInterval(List<Long> timestamps) {
        if (timestamps.size() < 2) return 0;
        long totalDiff = 0;
        for (int i = 1; i < timestamps.size(); i++) {
            totalDiff += (timestamps.get(i) - timestamps.get(i - 1));
        }
        return totalDiff / (timestamps.size() - 1);
    }

    private static void generateSampleLogFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("2025-05-14 10:00:01 INFO Server started\n");
            writer.write("2025-05-14 10:03:15 INFO User login\n");
            writer.write("2025-05-14 10:05:21 ERROR Database failure\n");
            writer.write("2025-05-14 10:07:03 WARN Low memory\n");
            writer.write("2025-05-14 10:10:05 INFO Cache cleared\n");
            writer.write("2025-05-14 10:12:45 ERROR Disk full\n");
            writer.write("2025-05-14 10:15:00 WARN CPU spike\n");
        } catch (IOException e) {
            System.err.println("Error generating test log: " + e.getMessage());
        }
    }
}
