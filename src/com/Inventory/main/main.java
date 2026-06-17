package com.inventory.main;

import com.inventory.model.Product;
import com.inventory.service.ProductService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();

        while (true) {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Low Stock Alert");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter supplier name: ");
                    String supplier = sc.nextLine();

                    Product product = new Product(name, category, quantity, price, supplier);
                    service.addProduct(product);
                    break;

                case 2:
                    service.viewAllProducts();
                    break;

                case 3:
                    System.out.print("Enter product ID: ");
                    int searchId = sc.nextInt();
                    service.searchProductById(searchId);
                    break;

                case 4:
                    System.out.print("Enter product ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = sc.nextInt();

                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    service.updateProduct(updateId, newQuantity, newPrice);
                    break;

                case 5:
                    System.out.print("Enter product ID: ");
                    int deleteId = sc.nextInt();
                    service.deleteProduct(deleteId);
                    break;

                case 6:
                    service.lowStockAlert();
                    break;

                case 7:
                    System.out.println("Thank you for using Inventory Management System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
