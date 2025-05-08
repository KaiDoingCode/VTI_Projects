package service;

import model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void inputStudents(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Enter information for student " + (i + 1));
            System.out.print("ID: ");
            String id = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            students.add(new Student(id, name, age, gpa));
        }
    }

    public void displayHighGpaStudents() {
        System.out.println("\nStudents with GPA >= 3.2:");
        for (Student s : students) {
            if (s.getGpa() >= 3.2) {
                System.out.println(s);
            }
        }
    }

    public void sortStudentsByGpaDescending() {
        students.sort(Comparator.comparingDouble(Student::getGpa).reversed());
    }

    public void displayAllStudents() {
        System.out.println("\nAll students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
