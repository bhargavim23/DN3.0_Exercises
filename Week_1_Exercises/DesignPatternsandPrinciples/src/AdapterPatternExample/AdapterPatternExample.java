package AdapterPatternExample;

interface PaymentProcessor {
    void processPayment(double amount);
}

class Paypal {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made through PayPal.");
    }
}

class CreditCard {
    public void charge(double amount) {
        System.out.println("Charged $" + amount + " to credit card.");
    }
}


class PaypalAdapter implements PaymentProcessor {
    private Paypal paypal;

    public PaypalAdapter(Paypal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}

class CreditCardAdapter implements PaymentProcessor {
    private CreditCard creditCard;

    public CreditCardAdapter(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public void processPayment(double amount) {
        creditCard.charge(amount);
    }
}

// Test the Adapter Pattern
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PaypalAdapter(new Paypal());
        paypalProcessor.processPayment(100.0);

        PaymentProcessor creditCardProcessor = new CreditCardAdapter(new CreditCard());
        creditCardProcessor.processPayment(200.0);
    }
}
