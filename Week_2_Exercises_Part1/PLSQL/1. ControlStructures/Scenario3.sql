DECLARE
    CURSOR loan_cursor IS
        SELECT c.CustomerID,c.CustomerName,l.LoanID,l.DueDate
        FROM Customers c JOIN Loans l ON c.CustomerID=l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR i IN loan_cursor LOOP
        DBMS_OUTPUT>PUT_LINE("Reminder your loan payment is on due")
    END LOOP;
    COMMIT;
END;
