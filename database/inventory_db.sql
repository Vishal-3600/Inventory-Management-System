CREATE DATABASE inventory_db;

USE inventory_db;

CREATE TABLE products(
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100),
    category VARCHAR(50),
    quantity INT,
    price DOUBLE,
    supplier_name VARCHAR(100)
);
