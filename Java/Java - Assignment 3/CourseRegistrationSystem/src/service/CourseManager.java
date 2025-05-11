package service;

import entities.*;

import java.util.*;

public class CourseManager {
    private Map<String, Course> courses = new HashMap<>();

    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
    }

    public void updateCourseName(String courseId, String newName) {
        Course course = courses.get(courseId);
        if (course != null) {
            course.setCourseName(newName);
        }
    }

    public void deleteCourse(String courseId) {
        courses.remove(courseId);
    }

    public Course getCourse(String courseId) {
        return courses.get(courseId);
    }

    public void printAllCourses() {
        for (Course c : courses.values()) {
            c.displayCourseInfo();
            System.out.println();
        }
    }
}
