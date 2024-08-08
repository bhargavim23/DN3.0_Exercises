DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    transaction_record GenerateMonthlyStatements%ROWTYPE;
BEGIN
    OPEN GenerateMonthlyStatements;
    LOOP
        FETCH GenerateMonthlyStatements INTO transaction_record;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || transaction_record.CustomerID);
        DBMS_OUTPUT.PUT_LINE('Name: ' || transaction_record.Name);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || transaction_record.TransactionDate);
        DBMS_OUTPUT.PUT_LINE('Amount: ' || transaction_record.Amount);
        DBMS_OUTPUT.PUT_LINE('Transaction Type: ' || transaction_record.TransactionType);
        DBMS_OUTPUT.PUT_LINE('-------------------------');
    END LOOP;
    CLOSE transactions_cur;
END;
/
