CREATE TABLE AuditLog(
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    AuditDate DATE DEFAULT SYSDATE
)

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions FOR EACH ROW
BEGIN
    INSERT INTO AduitLog(AuditId,TransactionId,AccountId,TransactionDate,Amount,TransactionType)
    VALUES (AuditLogseq.NEXTVAL,:NEW>TransactionId,:New.AccountId,:NEW.TransactionDate,:NEW.Amount,:NEW.TransactionType);
END LogTransaction;
/