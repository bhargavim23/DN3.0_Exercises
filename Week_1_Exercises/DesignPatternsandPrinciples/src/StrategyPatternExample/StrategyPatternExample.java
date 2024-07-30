package StrategyPatternExample;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account: " + email);
    }
}


class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}


public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentStrategy creditCardPayment = new CreditCardPayment("1243-5678-9876-5432");
        PaymentContext context = new PaymentContext(creditCardPayment);
        context.executePayment(200.0);

        PaymentStrategy paypalPayment = new PayPalPayment("username@example.com");
        context = new PaymentContext(paypalPayment);
        context.executePayment(150.0);
    }
}
