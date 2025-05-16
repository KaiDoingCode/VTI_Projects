import appconfig.AppConfigDemo;
import logger.LoggerDemo;
import database.DatabaseDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== AppConfig Demo ===");
        AppConfigDemo.run();

        System.out.println("\n=== Logger Demo ===");
        LoggerDemo.run();

        System.out.println("\n=== DatabaseConnection Demo ===");
        DatabaseDemo.run();
    }
}
