package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(String id, String name, String email) {
        super(id, name, email);
    }

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.enrollStudent(this);
        }
    }

    public void viewGrades() {
        for (Course course : enrolledCourses) {
            Double grade = course.getGrade(this);
            System.out.println("Course: " + course.getTitle() + " - Grade: " + (grade != null ? grade : "Not graded yet"));
        }
    }

    @Override
    public void login() {
        System.out.println("Student " + name + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Student " + name + " logged out.");
    }
}
