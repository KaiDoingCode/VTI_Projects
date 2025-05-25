package application;

import domain.Employee;

public class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name) {
        this.name = name;
        this.position = "Developer";
    }

    @Override
    public void displayDetails() {
        System.out.println("- " + position + ": " + name);
    }
}
