CREATE DATABASE UniversityEnrollment;
USE UniversityEnrollment;

CREATE TABLE UniversityEnrollment.Students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    gender ENUM('Male', 'Female') NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    gpa DECIMAL(3,2) CHECK (gpa >= 0.0 AND gpa <= 4.0)
);

CREATE TABLE UniversityEnrollment.Professors (
    professor_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    hire_date DATE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE UniversityEnrollment.Courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    credits TINYINT CHECK (credits >= 1 AND credits <= 5),
    professor_id INT NOT NULL,
    FOREIGN KEY (professor_id) REFERENCES Professors(professor_id)
        ON DELETE CASCADE
);

CREATE TABLE UniversityEnrollment.Enrollments (
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    enroll_date DATE NOT NULL,
    grade TINYINT CHECK (grade >= 1 AND grade <= 20),
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES Students(student_id)
        ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
        ON DELETE CASCADE
);

CREATE TABLE UniversityEnrollment.Grades (
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    grade TINYINT CHECK (grade >= 1 AND grade <= 20),
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id, course_id) REFERENCES Enrollments(student_id, course_id)
        ON DELETE CASCADE
);
