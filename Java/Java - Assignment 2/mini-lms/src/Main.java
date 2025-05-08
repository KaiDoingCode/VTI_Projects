//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import model.*;
import service.LMS;

public class Main {
    public static void main(String[] args) {
        LMS lms = new LMS();

        Instructor instructor1 = new Instructor("I001", "Alice", "alice@edu.com");
        Student student1 = new Student("S001", "Bob", "bob@edu.com");
        Student student2 = new Student("S002", "Charlie", "charlie@edu.com");

        lms.addUser(instructor1);
        lms.addUser(student1);
        lms.addUser(student2);

        instructor1.login();
        student1.login();

        lms.createCourse(instructor1, "C001", "Java Programming");
        Course javaCourse = instructor1.createCourse("C002", "Data Structures");
        lms.enroll(student1, javaCourse);
        lms.enroll(student2, javaCourse);

        lms.grade(instructor1, javaCourse, student1, 90.5);
        lms.grade(instructor1, javaCourse, student2, 85.0);

        lms.printTranscript(student1);
        lms.printTranscript(student2);

        instructor1.logout();
        student1.logout();
    }
}
