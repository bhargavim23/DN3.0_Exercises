DELIMITER //
CREATE PROCEDURE TransferFunds(
    IN SourceAcc NUMBER,
    IN DestAcc NUMBER,
    IN amount NUMBER
)
BEGIN
    DECLARE insufficientFunds EXCEPTION;
    DECLARE currentBalance NUMBER;
    SELECT Balance INTO currentBalance
    FROM Accounts
    WHERE AccountID = sourceAccountId;

    IF currentBalance < amount THEN
        RAISE insufficientFunds;
    END IF;
    UPDATE Accounts
    SET Balance = Balance - amount,
        LastModified = CURRENT_DATE
    WHERE AccountID = sourceAccountId;
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (NEXTVAL('TransactionSeq'), sourceAccountId, CURRENT_DATE, -amount, 'Withdrawal');
    UPDATE Accounts
    SET Balance = Balance + amount,
        LastModified = CURRENT_DATE
    WHERE AccountID = targetAccountId;
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (NEXTVAL('TransactionSeq'), targetAccountId, CURRENT_DATE, amount, 'Deposit');
END //

DELIMITER ;