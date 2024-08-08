CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(employeeID NUMBER, name VARCHAR2, position VARCHAR2, salary NUMBER, department VARCHAR2, hireDate DATE);
    PROCEDURE UpdateEmployeeDetails(employeeID NUMBER, name VARCHAR2, position VARCHAR2, salary NUMBER, department VARCHAR2);
    FUNCTION CalculateAnnualSalary(employeeID NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(employeeID NUMBER, name VARCHAR2, position VARCHAR2, salary NUMBER, department VARCHAR2, hireDate DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (employeeID, name, position, salary, department, hireDate);
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails(employeeID NUMBER, name VARCHAR2, position VARCHAR2, salary NUMBER, department VARCHAR2) IS
    BEGIN
        UPDATE Employees
        SET Name = name, Position = position, Salary = salary, Department = department
