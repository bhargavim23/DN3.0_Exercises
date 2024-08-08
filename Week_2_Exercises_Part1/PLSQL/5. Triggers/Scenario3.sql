CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    currentBalance NUMBER;
BEGIN
    SELECT Balance INTO currentBalance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID
    FOR UPDATE;

    IF :NEW.TransactionType = 'Withdrawal' AND currentBalance < ABS(:NEW.Amount) THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for withdrawal');
    ELSIF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive');
    END IF;
END CheckTransactionRules;
/
