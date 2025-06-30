-- Create db "databaseviews" and start using it as current db
DROP DATABASE IF EXISTS databaseviews;
CREATE DATABASE databaseviews;

USE databaseviews;

-- Create "customers" and "orders" tables
CREATE TABLE customers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Create a "customer_order_summary" view
CREATE VIEW customer_order_summary AS
SELECT 
    c.id AS customer_id,
    c.name AS customer_name,
    COUNT(o.id) AS total_orders,
    SUM(o.total_amount) AS total_spent
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id
GROUP BY c.id, c.name;

-- Populating "customers" and "orders" tables with some data
INSERT INTO customers (name) VALUES ('Alice'), ('Bob');
INSERT INTO orders (customer_id, total_amount) VALUES (1, 100.50), (1, 200.75), (2, 50.25);



