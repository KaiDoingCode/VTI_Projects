package application;

import domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    @Override
    public void displayDetails() {
        System.out.println(position + ": " + name);
        for (Employee e : subordinates) {
            e.displayDetails();
        }
    }
}

