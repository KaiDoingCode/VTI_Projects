package service;

import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void displayEmployees() {
        System.out.println("\nEmployee List:");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    public double calculateTotalSalary() {
        double total = 0;
        for (Employee emp : employeeList) {
            total += emp.calculateSalary();
        }
        return total;
    }
}
