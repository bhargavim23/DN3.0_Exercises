package ObserverPatternExample;

import java.util.ArrayList;
import java.util.List;

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }
}

// Observer Interface
interface Observer {
    void update(String stockName, double stockPrice);
}

class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Mobile App Notification: " + stockName + " is now $" + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Web App Notification: " + stockName + " is now $" + stockPrice);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("ABC Corp", 100.0);

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(105.0);
        stockMarket.setStockPrice(110.0);
    }
}


