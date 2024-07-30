package eCommerceManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }

    public static void linearSearch(HashMap<Integer, Product> ecommerce, int productId) {
        boolean found = false;
        for (Map.Entry<Integer, Product> entry : ecommerce.entrySet()) {
            if (entry.getKey() == productId) {
                System.out.println("Product Found: " + entry.getValue());
                found = true;
                break; // Exit loop early once found
            }
        }
        if (!found) {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public static void binarySearch(HashMap<Integer, Product> ecommerce, int productId) {
        List<Integer> productIds = new ArrayList<>(ecommerce.keySet());
        Collections.sort(productIds);

        int l = 0;
        int r = productIds.size() - 1;
        boolean found = false;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midId = productIds.get(mid);

            if (midId == productId) {
                System.out.println("Product Found: " + ecommerce.get(midId));
                found = true;
                break;
            } else if (midId < productId) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public static void display(HashMap<Integer, Product> ecommerce) {
        System.out.println("Product Inventory:");
        System.out.printf("%-10s %-20s %-10s\n", "Product ID", "Product Name", "Category");
        System.out.println("---------------------------------------------");
        for (Map.Entry<Integer, Product> entry : ecommerce.entrySet()) {
            Product product = entry.getValue();
            System.out.printf("%-10d %-20s %-10s\n", product.productId, product.productName, product.category);
        }
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Product> ecommerce = new HashMap<>();

        // Populate the HashMap with unique product IDs
        ecommerce.put(1234, new Product(1234, "Kurti", "Women"));
        ecommerce.put(2234, new Product(2234, "Pyjama", "Men"));
        ecommerce.put(3234, new Product(3234, "Saree", "Women"));
        ecommerce.put(6234, new Product(6234, "Frock", "Women"));
        ecommerce.put(8234, new Product(8234, "Jeans", "Men"));
        ecommerce.put(7234, new Product(7234, "Top", "Women"));
        ecommerce.put(9234, new Product(9234, "T-shirt", "Men"));
        ecommerce.put(234, new Product(234, "Shirt", "Men")); // Changed 0234 to 234

        display(ecommerce);

        System.out.print("Enter the product ID to search: ");
        int productId = sc.nextInt();

        // Perform linear search
        System.out.println("Performing linear search...");
        linearSearch(ecommerce, productId);

        // Perform binary search
        System.out.println("Performing binary search...");
        binarySearch(ecommerce, productId);

        sc.close();
    }
}
