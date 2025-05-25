import application.*;
import domain.Employee;


public class Main {
    public static void main(String[] args) {
        // Leaves
        Employee dev1 = new Developer("Alice");
        Employee dev2 = new Developer("Bob");
        Employee designer1 = new Designer("Charlie");

        // Manager with developers
        Manager techLead = new Manager("Eve", "Tech Lead");
        techLead.add(dev1);
        techLead.add(dev2);

        // Higher-level manager
        Manager projectManager = new Manager("Dave", "Project Manager");
        projectManager.add(techLead);
        projectManager.add(designer1);

        // Print the company structure
        System.out.println("Company Structure:");
        projectManager.displayDetails();
    }
}
