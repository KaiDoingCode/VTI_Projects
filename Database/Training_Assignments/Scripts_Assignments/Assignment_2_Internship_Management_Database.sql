-- Script: Internship Management Database (ThucTap)

-- 1. Create Tables
CREATE TABLE GiangVien (
    magv INT PRIMARY KEY,
    hoten NVARCHAR(100),
    luong FLOAT
);

CREATE TABLE SinhVien (
    masv INT PRIMARY KEY,
    hoten NVARCHAR(100),
    namsinh INT,
    quequan NVARCHAR(100)
);

CREATE TABLE DeTai (
    madt INT PRIMARY KEY,
    tendt NVARCHAR(200),
    kinhphi FLOAT,
    NoiThucTap NVARCHAR(200)
);

CREATE TABLE HuongDan (
    id INT PRIMARY KEY,
    masv INT,
    madt INT,
    magv INT,
    ketqua FLOAT,
    FOREIGN KEY (masv) REFERENCES SinhVien(masv) ON DELETE CASCADE,
    FOREIGN KEY (madt) REFERENCES DeTai(madt),
    FOREIGN KEY (magv) REFERENCES GiangVien(magv)
);

GO

-- Insert sample data
INSERT INTO GiangVien (magv, hoten, luong) VALUES (1, 'Dr. Smith', 2000);
INSERT INTO GiangVien (magv, hoten, luong) VALUES (2, 'Dr. John', 2500);
INSERT INTO GiangVien (magv, hoten, luong) VALUES (3, 'Dr. Alice', 2200);

INSERT INTO SinhVien (masv, hoten, namsinh, quequan) VALUES (101, 'Alice Nguyen', 2002, 'Hanoi');
INSERT INTO SinhVien (masv, hoten, namsinh, quequan) VALUES (102, 'Bob Tran', 2001, 'Saigon');
INSERT INTO SinhVien (masv, hoten, namsinh, quequan) VALUES (103, 'Charlie Pham', 2003, 'Danang');

INSERT INTO DeTai (madt, tendt, kinhphi, NoiThucTap) VALUES (201, 'CONG NGHE SINH HOC', 5000, 'BioLab Co.');
INSERT INTO DeTai (madt, tendt, kinhphi, NoiThucTap) VALUES (202, 'AI RESEARCH', 7000, 'TechLab Co.');
INSERT INTO DeTai (madt, tendt, kinhphi, NoiThucTap) VALUES (203, 'ROBOTICS PROJECT', 8000, 'RoboCorp.');

INSERT INTO HuongDan (id, masv, madt, magv, ketqua) VALUES (1, 101, 201, 1, 8.5);
INSERT INTO HuongDan (id, masv, madt, magv, ketqua) VALUES (2, 102, 202, 2, 9.0);
-- Student 103 has no HuongDan record yet

GO

-- 2. Queries

-- a) Students without assigned topics
SELECT sv.masv, sv.hoten
FROM SinhVien sv
LEFT JOIN HuongDan hd ON sv.masv = hd.masv
WHERE hd.masv IS NULL;

-- b) Number of students doing the topic 'CONG NGHE SINH HOC'
SELECT COUNT(*) AS NumberOfStudents
FROM HuongDan hd
JOIN DeTai dt ON hd.madt = dt.madt
WHERE dt.tendt = 'CONG NGHE SINH HOC';

GO

-- 3. Create View SinhVienInfo
CREATE VIEW SinhVienInfo AS
SELECT
    sv.masv,
    sv.hoten,
    ISNULL(dt.tendt, 'Chưa có') AS tendt
FROM SinhVien sv
LEFT JOIN HuongDan hd ON sv.masv = hd.masv
LEFT JOIN DeTai dt ON hd.madt = dt.madt;
GO

-- 4. Create Trigger for checking Year of Birth
CREATE TRIGGER CheckNamSinh
ON SinhVien
AFTER INSERT
AS
BEGIN
    IF EXISTS (SELECT * FROM inserted WHERE namsinh <= 1900)
    BEGIN
        RAISERROR ('Năm sinh phải > 1900', 16, 1);
        ROLLBACK TRANSACTION;
    END
END;
GO

-- 5. Table configuration to delete HuongDan when deleting SinhVien
-- (Already done with FOREIGN KEY ON DELETE CASCADE in HuongDan.masv)

-- Test deleting student:
-- DELETE FROM SinhVien WHERE masv = 101;
-- (It will also automatically delete HuongDan record with masv=101)
