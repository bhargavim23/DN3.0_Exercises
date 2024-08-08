DECLARE
    annualFee CONSTANT NUMBER := 50;
    CURSOR accounts_cur IS
        SELECT AccountID, Balance FROM Accounts;

    account_record accounts_cur%ROWTYPE;
BEGIN
    OPEN accounts_cur;
    LOOP
        FETCH accounts_cur INTO account_record;
        EXIT WHEN accounts_cur%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - annualFee,
            LastModified = SYSDATE
        WHERE AccountID = account_record.AccountID;
        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (TransactionSeq.NEXTVAL, account_record.AccountID, SYSDATE, -annualFee, 'Fee');
    END LOOP;
    CLOSE accounts_cur;
    COMMIT;
END;
/
