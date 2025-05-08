package model;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User implements Gradable {
    private List<Course> courseList = new ArrayList<>();

    public Instructor(String id, String name, String email) {
        super(id, name, email);
    }

    public Course createCourse(String courseId, String title) {
        Course course = new Course(courseId, title, this);
        courseList.add(course);
        return course;
    }

    @Override
    public void gradeStudent(Course course, Student student, double grade) {
        if (courseList.contains(course)) {
            course.assignGrade(student, grade);
        } else {
            System.out.println("You are not the instructor for this course.");
        }
    }

    @Override
    public void login() {
        System.out.println("Instructor " + name + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Instructor " + name + " logged out.");
    }
}
