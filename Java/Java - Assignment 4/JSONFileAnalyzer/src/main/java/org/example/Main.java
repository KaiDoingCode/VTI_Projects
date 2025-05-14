package org.example;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String jsonFile = "users.json";
        String csvFile = "filtered_users.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile))) {
            writer.write("[\n");
            writer.write("{\"name\": \"Alice\", \"age\": 35, \"address\": \"123 Main St\", \"email\": \"alice@example.com\"},\n");
            writer.write("{\"name\": \"Bob\", \"age\": 25, \"address\": \"456 Oak Ave\", \"email\": \"bob@example.com\"},\n");
            writer.write("{\"name\": \"Carol\", \"age\": 42, \"address\": \"789 Pine Rd\", \"email\": \"carol@example.com\"}\n");
            writer.write("]");
            System.out.println("Sample users.json file created.");
        } catch (IOException e) {
            System.err.println("Error writing JSON: " + e.getMessage());
            return;
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))
        ) {
            writer.write("name,age,address,email");
            writer.newLine();

            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createParser(reader);
            ObjectMapper mapper = new ObjectMapper();

            if (parser.nextToken() != JsonToken.START_ARRAY) {
                throw new RuntimeException("Expected start of array in JSON");
            }

            while (parser.nextToken() == JsonToken.START_OBJECT) {
                JsonNode user = mapper.readTree(parser);
                int age = user.get("age").asInt();

                if (age > 30) {
                    String name = user.get("name").asText();
                    String address = user.get("address").asText();
                    String email = user.get("email").asText();
                    writer.write(String.format("%s,%d,%s,%s", name, age, escapeCsv(address), email));
                    writer.newLine();
                }
            }

            System.out.println("Filtered users written to " + csvFile);

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    private static String escapeCsv(String value) {
        if (value.contains(",") || value.contains("\"")) {
            value = value.replace("\"", "\"\"");
            return "\"" + value + "\"";
        }
        return value;
    }
}
