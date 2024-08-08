DELIMITER //
CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts SET Balance = Balance*1.01,
    LastModified = CURRENT_DATE
    WHERE AccountType = 'Savings';
END
//