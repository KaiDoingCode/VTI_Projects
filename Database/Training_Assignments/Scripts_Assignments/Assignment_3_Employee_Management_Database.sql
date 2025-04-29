-- Script: Employee Management Database

-- 1. Create Tables
CREATE TABLE Country (
    country_id INT PRIMARY KEY,
    country_name NVARCHAR(100)
);

CREATE TABLE Location (
    location_id INT PRIMARY KEY,
    street_address NVARCHAR(200),
    postal_code NVARCHAR(20),
    country_id INT,
    FOREIGN KEY (country_id) REFERENCES Country(country_id)
);

CREATE TABLE Employee (
    employee_id INT PRIMARY KEY,
    full_name NVARCHAR(100),
    email NVARCHAR(100),
    location_id INT,
    FOREIGN KEY (location_id) REFERENCES Location(location_id) ON DELETE SET NULL
);

GO

-- Insert sample data
INSERT INTO Country (country_id, country_name) VALUES (1, 'Vietnam');
INSERT INTO Country (country_id, country_name) VALUES (2, 'USA');
INSERT INTO Country (country_id, country_name) VALUES (3, 'Japan');

INSERT INTO Location (location_id, street_address, postal_code, country_id) VALUES (101, '123 Hanoi Street', '10000', 1);
INSERT INTO Location (location_id, street_address, postal_code, country_id) VALUES (102, '456 New York Ave', '20000', 2);
INSERT INTO Location (location_id, street_address, postal_code, country_id) VALUES (103, '789 Tokyo Blvd', '30000', 3);

INSERT INTO Employee (employee_id, full_name, email, location_id) VALUES (1, 'Nguyen Nam', 'nn01@gmail.com', 101);
INSERT INTO Employee (employee_id, full_name, email, location_id) VALUES (2, 'Le Hoa', 'nn02@gmail.com', 101);
INSERT INTO Employee (employee_id, full_name, email, location_id) VALUES (3, 'Pham Binh', 'nn03@gmail.com', 102);

GO

-- 2. Queries
-- a) Get all employees from Vietnam
SELECT e.*
FROM Employee e
JOIN Location l ON e.location_id = l.location_id
JOIN Country c ON l.country_id = c.country_id
WHERE c.country_name = 'Vietnam';

-- b) Get country name of employee with email 'nn03@gmail.com'
SELECT c.country_name
FROM Employee e
JOIN Location l ON e.location_id = l.location_id
JOIN Country c ON l.country_id = c.country_id
WHERE e.email = 'nn03@gmail.com';

-- c) Count employees by country and location
SELECT
    c.country_name,
    l.location_id,
    COUNT(e.employee_id) AS employee_count
FROM Country c
JOIN Location l ON c.country_id = l.country_id
LEFT JOIN Employee e ON l.location_id = e.location_id
GROUP BY c.country_name, l.location_id;

GO

-- 3. Trigger: limit max 10 employees per country
CREATE TRIGGER LimitEmployeePerCountry
ON Employee
AFTER INSERT
AS
BEGIN
    DECLARE @location_id INT, @country_id INT, @count INT;

    SELECT TOP 1 @location_id = location_id FROM inserted;
    SELECT TOP 1 @country_id = country_id FROM Location WHERE location_id = @location_id;

    SELECT @count = COUNT(*)
    FROM Employee e
    JOIN Location l ON e.location_id = l.location_id
    WHERE l.country_id = @country_id;

    IF @count > 10
    BEGIN
        RAISERROR ('Each country can have at most 10 employees.', 16, 1);
        ROLLBACK TRANSACTION;
    END
END;
GO

-- 4. Table Configuration: already set "ON DELETE SET NULL" for Employee.location_id
-- (See table creation: FOREIGN KEY (location_id) REFERENCES Location(location_id) ON DELETE SET NULL)

-- So when a Location is deleted, employees' location_id will be set to NULL automatically.
