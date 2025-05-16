package database.domain;

public enum DatabaseConnection {
    INSTANCE;

    private boolean connected = false;

    public void connect() {
        if (!connected) {
            connected = true;
            System.out.println("Connected to database.");
        } else {
            System.out.println("Already connected.");
        }
    }

    public void disconnect() {
        if (connected) {
            connected = false;
            System.out.println("Disconnected from database.");
        }
    }
}
