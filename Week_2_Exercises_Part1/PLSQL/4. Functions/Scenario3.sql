CREATE OR REPLACE FUNCTION HasSufficientBalance(
    accountId NUMBER,amount NUMBER
)RETURN BOOLEAN IS
    currentBalance NUMBER;
BEGIN
    SELECT Balance INTO currentBalance
    FROM Accounts
    WHERE AccountID = accountId;
    
    RETURN currentBalance >= amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END HasSufficientBalance;
/