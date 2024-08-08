DECLARE
    newInterestRate CONSTANT NUMBER := 5; 
    CURSOR loans_cur IS
        SELECT LoanID, InterestRate FROM Loans;

    loan_record loans_cur%ROWTYPE;
BEGIN
    OPEN loans_cur;
    LOOP
        FETCH loans_cur INTO loan_record;
        EXIT WHEN loans_cur%NOTFOUND;

        UPDATE Loans
        SET InterestRate = newInterestRate
        WHERE LoanID = loan_record.LoanID;
    END LOOP;
    CLOSE loans_cur;
    COMMIT;
END;
/
