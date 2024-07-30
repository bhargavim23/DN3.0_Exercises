package financialForecasting;

import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double principal, double rate, int y) {
        if (y == 0) {
            return principal;
        }
        return calculateFutureValue(principal * (1 + rate), rate, y - 1);
    }

    // Main method to interact with the FinancialForecast
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial principal amount: ");
        double principal = sc.nextDouble();
        System.out.print("Enter annual growth rate (as a decimal): ");
        double rate = sc.nextDouble();
        System.out.print("Enter number of years: ");
        int y = sc.nextInt();

        double futureValue = calculateFutureValue(principal, rate, y);
        System.out.printf("Future value after %d years is: %.2f\n", y, futureValue);

        sc.close();
    }
}
