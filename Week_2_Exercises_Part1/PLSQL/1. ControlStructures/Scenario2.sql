DECLARE
    CURSOR customer_cursor IS
        SELECT c.CustomerID
        FROM Customers c
        WHERE c.Balance > 10000;
BEGIN
    FOR i IN customer_cursor LOOP
        UPDATE Customers
        SET IsVIP = TRUE
        WHERE CustomerID = i.CustomerID;
    END LOOP;
    COMMIT;
END;
