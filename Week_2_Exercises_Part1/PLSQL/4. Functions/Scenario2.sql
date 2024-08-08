CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    LoanAmount NUMBER,
    InterestRate NUMBER,
    Duration NUMBER
)RETURN NUMBER IS
    monthly_interest_rate NUMBER;
    number_of_payments NUMBER;
    monthly_installment NUMBER;
BEGIN
    monthly_interest_rate := InterestRate / 12 / 100;
    number_of_payments := Duration * 12;
    
    IF monthly_interest_rate = 0 THEN
        monthly_installment := LoanAmount / number_of_payments;
    ELSE
        monthly_installment := LoanAmount * monthly_interest_rate / 
            (1 - POWER(1 + monthly_interest_rate, -number_of_payments));
    END IF;
    
    RETURN monthly_installment;
    
END CalculateMonthlyInstallment;