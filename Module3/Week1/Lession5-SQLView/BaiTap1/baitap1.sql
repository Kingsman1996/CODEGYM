create database demo;
use demo;

CREATE TABLE Products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productCode VARCHAR(50) NOT NULL,
    productName VARCHAR(255) NOT NULL,
    productPrice DECIMAL(10,2) NOT NULL,
    productAmount INT NOT NULL CHECK (productAmount >= 0),
    productDescription TEXT,
    productStatus ENUM('Active', 'Inactive') NOT NULL DEFAULT 'Active'
);

INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
VALUES
('P001', 'Laptop Dell XPS 13', 25990.00, 10, 'Laptop cao cấp với màn hình 4K', 'Active'),
('P002', 'iPhone 15 Pro Max', 32990.00, 15, 'Điện thoại flagship của Apple', 'Active'),
('P003', 'Samsung Galaxy S24 Ultra', 28990.00, 20, 'Smartphone cao cấp với S-Pen', 'Active'),
('P004', 'Bàn phím cơ Keychron K6', 1990.00, 30, 'Bàn phím cơ không dây, switch Brown', 'Inactive'),
('P005', 'Tai nghe Sony WH-1000XM5', 7990.00, 25, 'Tai nghe chống ồn hàng đầu', 'Active'),
('P006', 'Màn hình LG UltraGear 27"', 10590.00, 12, 'Màn hình gaming 165Hz, IPS', 'Active'),
('P007', 'MacBook Air M2', 24990.00, 8, 'Laptop mỏng nhẹ, chip M2 mạnh mẽ', 'Active'),
('P008', 'Chuột Logitech MX Master 3S', 2590.00, 40, 'Chuột không dây chuyên nghiệp', 'Active');

EXPLAIN SELECT * FROM Products WHERE productCode = 'P001';
EXPLAIN SELECT * FROM Products WHERE productName = 'MacBook Air M2' AND productPrice = 24990.00;
-- rows = 8, duyệt toàn bộ bảng

CREATE  UNIQUE  INDEX idx_product_code ON Products(productCode);
CREATE  INDEX idx_product_name_price ON Products(productName, productPrice);

EXPLAIN SELECT * FROM Products WHERE productCode = 'P001';
EXPLAIN SELECT * FROM Products WHERE productName = 'MacBook Air M2' AND productPrice = 24990.00;
-- rows = 1, tìm thấy ngay

-- Tạo view
CREATE VIEW ProductView AS
SELECT productCode, productName, productPrice, productStatus
FROM Products;
select * from ProductView;

-- Sửa view
CREATE OR REPLACE VIEW ProductView AS
SELECT productCode, productName, productPrice, productStatus, productAmount
FROM Products;
select * from ProductView;

-- Xóa view
DROP VIEW IF EXISTS ProductView;

-- Lấy toàn bộ sản phẩm
DELIMITER //
CREATE PROCEDURE GetAllProducts()
BEGIN
    SELECT * FROM Products;
END //
DELIMITER ;

-- Thêm sản phẩm 
DELIMITER //
CREATE PROCEDURE AddProduct(
    IN code VARCHAR(50),
    IN name VARCHAR(255),
    IN price DECIMAL(10,2),
    IN amount INT,
    IN description TEXT,
    IN status ENUM('Active', 'Inactive')
)
BEGIN
    INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
    VALUES (code, name, price, amount, description, status);
END //
DELIMITER ;

-- Sửa theo id
DELIMITER //
CREATE PROCEDURE UpdateProduct(
    IN in_id INT,
    IN name VARCHAR(255),
    IN price DECIMAL(10,2),
    IN amount INT,
    IN description TEXT,
    IN status ENUM('Active', 'Inactive')
)
BEGIN
    UPDATE Products
    SET productName = name,
        productPrice = price,
        productAmount = amount,
        productDescription = description,
        productStatus = status
    WHERE id = in_id;
END //
DELIMITER ;

-- xóa theo id
DELIMITER //
CREATE PROCEDURE DeleteProduct(IN in_id INT)
BEGIN
    DELETE FROM Products WHERE id = in_id;
END //
DELIMITER ;

-- kiểm tra 
call GetAllProducts();
CALL AddProduct('P009', 'Apple Watch Series 9', 10990.00, 20, 'Smartwatch cao cấp của Apple', 'Active');
CALL UpdateProduct(1, 'MacBook Pro M3', 39990.00, 5, 'Laptop cao cấp của Apple', 'Active');
CALL DeleteProduct(2);

