package com.inventory.model;

public class Product {

    private int productId;
    private String productName;
    private String category;
    private int quantity;
    private double price;
    private String supplierName;

    public Product() {}

    public Product(String productName, String category, int quantity, double price, String supplierName) {
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.supplierName = supplierName;
    }

    public Product(int productId, String productName, String category, int quantity, double price, String supplierName) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.supplierName = supplierName;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getSupplierName() {
        return supplierName;
    }
}
