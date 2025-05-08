package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class LMS {
    private List<User> users = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        System.out.println("Added user: " + user.getName());
    }

    public void createCourse(Instructor instructor, String courseId, String title) {
        Course course = instructor.createCourse(courseId, title);
        courses.add(course);
        System.out.println("Created course: " + title + " by " + instructor.getName());
    }

    public void enroll(Student student, Course course) {
        student.enrollCourse(course);
        System.out.println(student.getName() + " enrolled in " + course.getTitle());
    }

    public void grade(Instructor instructor, Course course, Student student, double grade) {
        instructor.gradeStudent(course, student, grade);
        System.out.println("Graded " + student.getName() + " with " + grade + " in " + course.getTitle());
    }

    public void printTranscript(Student student) {
        System.out.println("\nTranscript for " + student.getName() + ":");
        student.viewGrades();
    }
}
