DECLARE
    CURSOR customer_cursor IS
        SELECT c.CustomerID, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60;
BEGIN
    FOR customer_rec IN customer_cursor LOOP
        UPDATE Loans
        SET InterestRate = customer_rec.InterestRate - 1
        WHERE LoanID = customer_rec.LoanID;
    END LOOP;
    COMMIT;
END;
