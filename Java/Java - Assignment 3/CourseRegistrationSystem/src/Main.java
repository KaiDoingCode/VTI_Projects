//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import entities.*;
import service.CourseManager;

public class Main {
    public static void main(String[] args) {
        CourseManager manager = new CourseManager();

        Instructor instructor1 = new Instructor(1, "Dr. Smith");
        Student s1 = new Student(1001, "Alice");
        Student s2 = new Student(1002, "Bob");

        Course course1 = new Course("CS101", "Intro to CS", instructor1);
        course1.addStudent(s1);
        course1.addStudent(s2);

        manager.addCourse(course1);

        manager.printAllCourses();

        System.out.println("--- Updating course name ---");
        manager.updateCourseName("CS101", "Computer Science Basics");
        manager.printAllCourses();

        System.out.println("--- Removing Bob ---");
        course1.removeStudent(s2);
        manager.printAllCourses();

        System.out.println("--- Deleting course ---");
        manager.deleteCourse("CS101");
        manager.printAllCourses();
    }
}