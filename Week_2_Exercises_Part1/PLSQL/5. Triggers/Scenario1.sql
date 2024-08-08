CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
AFTER UPDATE ON Customers FOR EACH ROW
BEGIN
    :NEW.LastModified:=SYSDATE;
END UpdateCustomerLastModified;
/