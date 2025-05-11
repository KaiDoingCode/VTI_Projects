package entities;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private Instructor instructor;
    private List<Student> students = new ArrayList<>();

    public Course(String courseId, String courseName, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseId() { return courseId; }

    public String getCourseName() { return courseName; }

    public void setCourseName(String name) { this.courseName = name; }

    public Instructor getInstructor() { return instructor; }

    public void setInstructor(Instructor instructor) { this.instructor = instructor; }

    public List<Student> getStudents() { return students; }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.enroll(this);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.drop(this);
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + " (ID: " + courseId + ")");
        System.out.println("Instructor: " + instructor.getName());
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}
