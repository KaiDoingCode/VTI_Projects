package application;

import domain.Employee;

public class Designer implements Employee {
    private String name;
    private String position;

    public Designer(String name) {
        this.name = name;
        this.position = "Designer";
    }

    @Override
    public void displayDetails() {
        System.out.println("- " + position + ": " + name);
    }
}

