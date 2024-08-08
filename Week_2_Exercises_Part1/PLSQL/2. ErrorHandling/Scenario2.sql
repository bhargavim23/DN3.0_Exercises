CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) IS
    e_employee_not_found EXCEPTION;
    v_employee_count NUMBER;
BEGIN
    -- Check if the employee exists
    SELECT COUNT(*) INTO v_employee_count
    FROM Employees
    WHERE EmployeeID = p_employee_id;

    IF v_employee_count = 0 THEN
        RAISE e_employee_not_found;
    END IF;

    -- Update salary
    UPDATE Employees
    SET Salary = Salary * (1 + p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    COMMIT;
EXCEPTION
    WHEN e_employee_not_found THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_employee_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
