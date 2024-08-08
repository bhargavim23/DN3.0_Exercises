DELIMITER //
CREATE PROCEDURE UpdateEmployeeBonus(
    IN departmentName VARCHAR2,
    IN bonusPercentage NUMBER
) 
BEGIN
    UPDATE Employees SET 
    Salary = Salary+(Salary*(bonusPercentage/100)) 
    WHERE Department = departmentName;
END//
DELIMITER;