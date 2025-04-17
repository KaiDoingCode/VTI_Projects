-- 🟢 Basic Level (1–10)

-- List all employees in the company
SELECT * FROM CompanyDB.Employee;

-- Show the name and email of employees in the "Engineering" department
SELECT e.employeeName, e.email
FROM CompanyDB.Employee e
JOIN CompanyDB.Department d ON e.departmentId = d.departmentId
WHERE d.departmentName = 'Engineering';


-- Get a list of projects that started in 2022
SELECT * FROM CompanyDB.Project
WHERE YEAR(startDate) = 2022;


-- Find employees hired after '2021-01-01'
SELECT * FROM CompanyDB.Employee
WHERE hireDate > '2021-01-01';


-- Display all departments in the company
SELECT * FROM CompanyDB.Department;


-- Get employee names and their salaries
SELECT employeeName, salary FROM CompanyDB.Employee;


-- Count the number of employees in each department
SELECT d.departmentName, COUNT(e.employeeId) AS employeeCount
FROM CompanyDB.Department d
LEFT JOIN CompanyDB.Employee e ON d.departmentId = e.departmentId
GROUP BY d.departmentName;


-- Find all projects with end dates after '2023-01-01'
SELECT * FROM CompanyDB.Project
WHERE endDate > '2023-01-01';


-- Get a list of employees with salary greater than 70,000
SELECT * FROM CompanyDB.Employee
WHERE salary > 70000;


-- List employees without a manager
SELECT * FROM CompanyDB.Employee
WHERE managerId IS NULL;

-- 🟡 Intermediate Level (11–20)

-- Calculate the total salary of employees per department
SELECT d.departmentName, SUM(e.salary) AS totalSalary
FROM CompanyDB.Department d
JOIN CompanyDB.Employee e ON d.departmentId = e.departmentId
GROUP BY d.departmentName;


-- List all projects that employee with ID = 2 is involved in
SELECT p.projectName
FROM CompanyDB.Project p
JOIN CompanyDB.EmployeeProject ep ON p.projectId = ep.projectId
WHERE ep.employeeId = 2;


-- Show employee names and their department names
SELECT e.employeeName, d.departmentName
FROM CompanyDB.Employee e
JOIN CompanyDB.Department d ON e.departmentId = d.departmentId;


-- Find the highest-paid employee in each department
SELECT e.*
FROM CompanyDB.Employee e
JOIN (
    SELECT departmentId, MAX(salary) AS maxSalary
    FROM CompanyDB.Employee
    GROUP BY departmentId
) AS sub ON e.departmentId = sub.departmentId AND e.salary = sub.maxSalary;



-- List employees involved in more than one project
SELECT e.employeeId, e.employeeName, COUNT(*) AS projectCount
FROM CompanyDB.EmployeeProject ep
JOIN CompanyDB.Employee e ON ep.employeeId = e.employeeId
GROUP BY ep.employeeId
HAVING COUNT(*) > 1;


-- Get project names and the number of employees involved in each
SELECT p.projectName, COUNT(ep.employeeId) AS employeeCount
FROM CompanyDB.Project p
LEFT JOIN CompanyDB.EmployeeProject ep ON p.projectId = ep.projectId
GROUP BY p.projectName;


-- List employees in "HR" department with salary > 60,000
SELECT e.*
FROM CompanyDB.Employee e
JOIN CompanyDB.Department d ON e.departmentId = d.departmentId
WHERE d.departmentName = 'HR' AND e.salary > 60000;


-- Show projects with no employees assigned
SELECT p.*
FROM CompanyDB.Project p
LEFT JOIN CompanyDB.EmployeeProject ep ON p.projectId = ep.projectId
WHERE ep.employeeId IS NULL;


-- List all employees along with their managers
SELECT e.employeeName AS employee, m.employeeName AS manager
FROM CompanyDB.Employee e
LEFT JOIN CompanyDB.Employee m ON e.managerId = m.employeeId;


-- Find employees in "Sales" department not assigned to any project
SELECT e.*
FROM CompanyDB.Employee e
JOIN CompanyDB.Department d ON e.departmentId = d.departmentId
LEFT JOIN CompanyDB.EmployeeProject ep ON e.employeeId = ep.employeeId
WHERE d.departmentName = 'Sales' AND ep.projectId IS NULL;

-- 🔵 Advanced Level (21–25)

-- List employee names, project names, and their assigned dates
SELECT e.employeeName, p.projectName, ep.assignedDate
FROM CompanyDB.EmployeeProject ep
JOIN CompanyDB.Employee e ON ep.employeeId = e.employeeId
JOIN CompanyDB.Project p ON ep.projectId = p.projectId;


-- Find projects with at least 3 employees assigned
SELECT p.projectName
FROM CompanyDB.EmployeeProject ep
JOIN CompanyDB.Project p ON ep.projectId = p.projectId
GROUP BY ep.projectId
HAVING COUNT(ep.employeeId) >= 3;


-- Find employees who work on both "Website Redesign" and "Mobile App" projects
SELECT e.employeeName
FROM CompanyDB.Employee e
JOIN CompanyDB.EmployeeProject ep ON e.employeeId = ep.employeeId
JOIN CompanyDB.Project p ON ep.projectId = p.projectId
WHERE p.projectName IN ('Website Redesign', 'Mobile App')
GROUP BY e.employeeId
HAVING COUNT(DISTINCT p.projectName) = 2;


-- List all employees who have the same manager as "Bob"
SELECT e.employeeName
FROM CompanyDB.Employee e
JOIN CompanyDB.Employee bob ON bob.employeeName = 'Bob'
WHERE e.managerId = bob.managerId AND e.employeeName <> 'Bob';


-- Show department names and average salary, only for departments with more than 1 employee
SELECT d.departmentName, AVG(e.salary) AS averageSalary
FROM CompanyDB.Department d
JOIN CompanyDB.Employee e ON d.departmentId = e.departmentId
GROUP BY d.departmentName
HAVING COUNT(e.employeeId) > 1;

-- 🔴 Expert Level (26–30)

-- Find the highest-paid employee in the company who is not a manager of anyone
SELECT * FROM CompanyDB.Employee
WHERE employeeId NOT IN (SELECT DISTINCT managerId FROM CompanyDB.Employee WHERE managerId IS NOT NULL)
ORDER BY salary DESC
LIMIT 1;


-- Show names of all projects that have at least one employee from "Engineering"
SELECT DISTINCT p.projectName
FROM CompanyDB.Project p
JOIN CompanyDB.EmployeeProject ep ON p.projectId = ep.projectId
JOIN CompanyDB.Employee e ON ep.employeeId = e.employeeId
JOIN CompanyDB.Department d ON e.departmentId = d.departmentId
WHERE d.departmentName = 'Engineering';


-- Display a "management tree" (employee – manager – grand-manager)
SELECT 
  e.employeeName AS employee,
  m.employeeName AS manager,
  gm.employeeName AS grandManager
FROM CompanyDB.Employee e
LEFT JOIN CompanyDB.Employee m ON e.managerId = m.employeeId
LEFT JOIN CompanyDB.Employee gm ON m.managerId = gm.employeeId;


-- Find employees who were assigned to a project before they were officially hired
SELECT e.employeeName, ep.assignedDate, e.hireDate
FROM CompanyDB.EmployeeProject ep
JOIN CompanyDB.Employee e ON ep.employeeId = e.employeeId
WHERE ep.assignedDate < e.hireDate;


-- List ongoing projects (not yet ended) with fewer than 3 employees
SELECT p.projectName
FROM CompanyDB.Project p
LEFT JOIN CompanyDB.EmployeeProject ep ON p.projectId = ep.projectId
WHERE p.endDate IS NULL OR p.endDate > CURDATE()
GROUP BY p.projectId
HAVING COUNT(ep.employeeId) < 3;
