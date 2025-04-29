-- Script: Student Grades Management Database

-- 1. Create Tables
CREATE TABLE Student (
    ID INT PRIMARY KEY,
    Name NVARCHAR(100),
    Age INT,
    Gender INT  -- 0 = Male, 1 = Female, NULL = Unknown
);

CREATE TABLE Subject (
    ID INT PRIMARY KEY,
    Name NVARCHAR(100)
);

CREATE TABLE StudentSubject (
    StudentID INT,
    SubjectID INT,
    Mark FLOAT,
    Date DATE,
    PRIMARY KEY (StudentID, SubjectID, Date),
    FOREIGN KEY (StudentID) REFERENCES Student(ID),
    FOREIGN KEY (SubjectID) REFERENCES Subject(ID)
);

-- Insert sample data
INSERT INTO Student (ID, Name, Age, Gender) VALUES (1, 'Alice', 20, 1);
INSERT INTO Student (ID, Name, Age, Gender) VALUES (2, 'Bob', 21, 0);
INSERT INTO Student (ID, Name, Age, Gender) VALUES (3, 'Charlie', 22, NULL);

INSERT INTO Subject (ID, Name) VALUES (101, 'Math');
INSERT INTO Subject (ID, Name) VALUES (102, 'Physics');
INSERT INTO Subject (ID, Name) VALUES (103, 'Chemistry');

INSERT INTO StudentSubject (StudentID, SubjectID, Mark, Date) VALUES (1, 101, 8.5, '2025-04-01');
INSERT INTO StudentSubject (StudentID, SubjectID, Mark, Date) VALUES (2, 101, 7.0, '2025-04-02');
INSERT INTO StudentSubject (StudentID, SubjectID, Mark, Date) VALUES (3, 102, 9.0, '2025-04-03');

GO

-- 2. Queries
-- a) Subjects without any marks
SELECT s.ID, s.Name
FROM Subject s
LEFT JOIN StudentSubject ss ON s.ID = ss.SubjectID
WHERE ss.SubjectID IS NULL;

-- b) Subjects with at least 2 marks
SELECT s.ID, s.Name
FROM Subject s
JOIN StudentSubject ss ON s.ID = ss.SubjectID
GROUP BY s.ID, s.Name
HAVING COUNT(ss.Mark) >= 2;

GO

-- 3. Create View
CREATE VIEW StudentInfo AS
SELECT
    st.ID AS StudentID,
    sub.ID AS SubjectID,
    st.Name AS StudentName,
    st.Age AS StudentAge,
    CASE
        WHEN st.Gender = 0 THEN 'Male'
        WHEN st.Gender = 1 THEN 'Female'
        ELSE 'Unknown'
    END AS StudentGender,
    sub.Name AS SubjectName,
    ss.Mark,
    ss.Date
FROM Student st
JOIN StudentSubject ss ON st.ID = ss.StudentID
JOIN Subject sub ON ss.SubjectID = sub.ID;
GO

-- 4. Triggers
-- a) Trigger for updating Subject ID
CREATE TRIGGER SubjectUpdateID
ON Subject
AFTER UPDATE
AS
BEGIN
    IF EXISTS (SELECT * FROM inserted) AND EXISTS (SELECT * FROM deleted)
    BEGIN
        UPDATE ss
        SET ss.SubjectID = i.ID
        FROM StudentSubject ss
        JOIN deleted d ON ss.SubjectID = d.ID
        JOIN inserted i ON d.ID <> i.ID;
    END
END;
GO

-- b) Trigger for deleting Student ID
CREATE TRIGGER StudentDeleteID
ON Student
AFTER DELETE
AS
BEGIN
    DELETE FROM StudentSubject
    WHERE StudentID IN (SELECT ID FROM deleted);
END;
GO

-- 5. Stored Procedure
CREATE PROCEDURE DeleteStudentInfo
    @StudentName NVARCHAR(100)
AS
BEGIN
    IF @StudentName = '*'
    BEGIN
        DELETE FROM StudentSubject;
        DELETE FROM Student;
    END
    ELSE
    BEGIN
        DELETE FROM StudentSubject
        WHERE StudentID IN (SELECT ID FROM Student WHERE Name = @StudentName);

        DELETE FROM Student
        WHERE Name = @StudentName;
    END
END;
GO
