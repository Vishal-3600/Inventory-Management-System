package com.inventory.dao;

import com.inventory.model.Product;
import com.inventory.util.DBConnection;

import java.sql.*;

public class ProductDAO {

    public void addProduct(Product product) {
        String query = "INSERT INTO products(product_name, category, quantity, price, supplier_name) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, product.getProductName());
            ps.setString(2, product.getCategory());
            ps.setInt(3, product.getQuantity());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getSupplierName());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product added successfully.");
            }

        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public void viewAllProducts() {
        String query = "SELECT * FROM products";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\nID | Name | Category | Quantity | Price | Supplier");
            System.out.println("----------------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " | " +
                        rs.getString("product_name") + " | " +
                        rs.getString("category") + " | " +
                        rs.getInt("quantity") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getString("supplier_name")
                );
            }

        } catch (Exception e) {
            System.out.println("Error viewing products: " + e.getMessage());
        }
    }

    public void searchProductById(int id) {
        String query = "SELECT * FROM products WHERE product_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("product_id"));
                System.out.println("Name: " + rs.getString("product_name"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Supplier: " + rs.getString("supplier_name"));
            } else {
                System.out.println("Product not found.");
            }

        } catch (Exception e) {
            System.out.println("Error searching product: " + e.getMessage());
        }
    }

    public void updateProduct(int id, int quantity, double price) {
        String query = "UPDATE products SET quantity = ?, price = ? WHERE product_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, quantity);
            ps.setDouble(2, price);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found.");
            }

        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    public void deleteProduct(int id) {
        String query = "DELETE FROM products WHERE product_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product not found.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting product: " + e.getMessage());
        }
    }

    public void lowStockAlert() {
        String query = "SELECT * FROM products WHERE quantity < 10";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\nLow Stock Products:");
            System.out.println("-------------------");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        rs.getString("product_name") +
                        " | Quantity: " + rs.getInt("quantity")
                );
            }

            if (!found) {
                System.out.println("No low stock products.");
            }

        } catch (Exception e) {
            System.out.println("Error checking low stock: " + e.getMessage());
        }
    }
}
