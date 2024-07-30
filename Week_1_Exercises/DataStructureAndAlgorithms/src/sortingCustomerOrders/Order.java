package sortingCustomerOrders;

import java.util.Scanner;

public class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public static void bubbleSort(Order[] orders, int size) {
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(orders, low, high);

            quickSort(orders, low, partitionIndex - 1);
            quickSort(orders, partitionIndex + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice<=pivot.totalPrice) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void display(Order[] orders) {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.orderId + ", Customer Name: " + order.customerName + ", Total Price: $" + order.totalPrice);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of orders:");
        int size = sc.nextInt();
        Order[] orders = new Order[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the order id:");
            int orderId = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.println("Enter the Customer Name:");
            String name = sc.nextLine();
            System.out.println("Enter the total price:");
            double totalPrice = sc.nextDouble();
            orders[i] = new Order(orderId, name, totalPrice);
        }

        System.out.println("The array before sorting..");
        display(orders);

        System.out.println("The array after bubble sort..");
        bubbleSort(orders, size);
        display(orders);

        System.out.println("The array after quick sort..");
        quickSort(orders, 0, size - 1);
        display(orders);

        sc.close();
    }
}
