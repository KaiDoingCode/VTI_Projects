package entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(int id, String name) {
        super(id, name);
    }

    public void enroll(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }

    public void drop(Course course) {
        enrolledCourses.remove(course);
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + name + ", ID: " + id);
    }
}
