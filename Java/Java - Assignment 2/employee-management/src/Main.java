//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import model.FullTimeEmployee;
import model.PartTimeEmployee;
import service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        employeeService.addEmployee(new FullTimeEmployee("FT01", "Alice", 3000));
        employeeService.addEmployee(new PartTimeEmployee("PT01", "Bob", 100, 15));
        employeeService.addEmployee(new PartTimeEmployee("PT02", "Charlie", 80, 20));

        employeeService.displayEmployees();

        double totalSalary = employeeService.calculateTotalSalary();
        System.out.println("\nTotal salary to pay: $" + totalSalary);
    }
}