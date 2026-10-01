
CREATE DATABASE IF NOT EXISTS MidtermDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE MidtermDB;

CREATE TABLE UserRoles (
    roleId INT AUTO_INCREMENT PRIMARY KEY,
    roleName VARCHAR(50)
);
CREATE TABLE Category (
    categoryId INT AUTO_INCREMENT PRIMARY KEY,
    categoryName VARCHAR(200),
    images VARCHAR(500),
    status INT
);
CREATE TABLE Seller (
    sellerId INT AUTO_INCREMENT PRIMARY KEY,
    sellername VARCHAR(50),
    images VARCHAR(500),
    status INT
);
CREATE TABLE Users (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100),
    fullname VARCHAR(50),
    password VARCHAR(50),
    images VARCHAR(500),
    phone VARCHAR(20),
    status INT,
    code VARCHAR(50),
    roleId INT,
    sellerId INT
);
CREATE TABLE Product (
    productId INT AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(200),
    productCode BIGINT,
    categoryId INT,
    description VARCHAR(500),
    price FLOAT,
    amount INT,
    stock INT,
    images VARCHAR(500),
    wishlist INT,
    status INT,
    createDate DATE,
    sellerId INT
);
CREATE TABLE Cart (
    cartId VARCHAR(50) PRIMARY KEY,
    userId INT,
    buyDate DATETIME,
    status INT
);
CREATE TABLE CartItem (
    cartItemId VARCHAR(50) PRIMARY KEY,
    quantity INT,
    unitPrice FLOAT,
    productId INT,
    cartId VARCHAR(50)
);

INSERT INTO UserRoles (roleName) VALUES ('Admin'), ('User');
INSERT INTO Seller (sellername, status) VALUES ('Shop A', 1), ('Shop B', 1);
INSERT INTO Category (categoryName, status) VALUES ('Electronics', 1), ('Clothing', 1);
INSERT INTO Users (username, email, fullname, password, roleId, status) VALUES ('admin', 'admin@gmail.com', 'Admin User', '123456', 1, 1);
INSERT INTO Product (productName, productCode, categoryId, description, price, amount, stock, images, status, sellerId) VALUES 
('Laptop', 101, 1, 'Gaming laptop', 1000, 10, 10, 'laptop.png', 1, 1),
('Shirt', 102, 2, 'Cotton shirt', 20, 50, 50, 'shirt.png', 1, 2);
