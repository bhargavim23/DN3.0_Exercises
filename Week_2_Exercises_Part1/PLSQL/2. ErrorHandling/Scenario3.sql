CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) IS
    e_duplicate_customer EXCEPTION;
    v_customer_count NUMBER;
BEGIN
    -- Check if the customer ID already exists
    SELECT COUNT(*) INTO v_customer_count
    FROM Customers
    WHERE CustomerID = p_customer_id;

    IF v_customer_count > 0 THEN
        RAISE e_duplicate_customer;
    END IF;

    -- Insert new customer
    INSERT INTO Customers (CustomerID, CustomerName, DOB, Balance, IsVIP)
    VALUES (p_customer_id, p_name, p_dob, p_balance, FALSE);

    COMMIT;
EXCEPTION
    WHEN e_duplicate_customer THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_customer_id || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddNewCustomer;
