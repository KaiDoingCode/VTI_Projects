//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        studentService.inputStudents(3); // You can change this number
        studentService.displayHighGpaStudents();

        System.out.println("\nSorting students by GPA (descending)...");
        studentService.sortStudentsByGpaDescending();
        studentService.displayAllStudents();
    }
}