package com.inventory.service;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;

public class ProductService {

    private ProductDAO productDAO = new ProductDAO();

    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    public void viewAllProducts() {
        productDAO.viewAllProducts();
    }

    public void searchProductById(int id) {
        productDAO.searchProductById(id);
    }

    public void updateProduct(int id, int quantity, double price) {
        productDAO.updateProduct(id, quantity, price);
    }

    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }

    public void lowStockAlert() {
        productDAO.lowStockAlert();
    }
}
