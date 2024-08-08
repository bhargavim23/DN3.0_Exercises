CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(customerID NUMBER, name VARCHAR2, dob DATE, initialBalance NUMBER);
    PROCEDURE UpdateCustomerDetails(customerID NUMBER, name VARCHAR2, dob DATE);
    FUNCTION GetCustomerBalance(customerID NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(customerID NUMBER, name VARCHAR2, dob DATE, initialBalance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (customerID, name, dob, initialBalance, SYSDATE);
    END AddCustomer;

    PROCEDURE UpdateCustomerDetails(customerID NUMBER, name VARCHAR2, dob DATE) IS
    BEGIN
        UPDATE Customers
        SET Name = name, DOB = dob, LastModified = SYSDATE
        WHERE CustomerID = customerID;
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance(customerID NUMBER) RETURN NUMBER IS
        balance NUMBER;
    BEGIN
        SELECT Balance INTO balance
        FROM Customers
        WHERE CustomerID = customerID;
        
        RETURN balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
/
