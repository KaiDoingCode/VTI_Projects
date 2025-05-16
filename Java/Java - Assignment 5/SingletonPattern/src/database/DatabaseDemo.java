package database;

import database.domain.DatabaseConnection;

public class DatabaseDemo {
    public static void run() {
        DatabaseConnection conn1 = DatabaseConnection.INSTANCE;
        conn1.connect();

        DatabaseConnection conn2 = DatabaseConnection.INSTANCE;
        conn2.connect();
    }
}
