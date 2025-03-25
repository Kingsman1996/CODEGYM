DELIMITER //
CREATE PROCEDURE getCusById
(IN cusNum INT)
BEGIN
  SELECT * FROM customers WHERE customerNumber = cusNum;
END 
// DELIMITER ;
call getCusById(450);

DELIMITER //
CREATE PROCEDURE GetCustomersCountByCity(
    IN input VARCHAR(25),
    OUT total INT
)
BEGIN
    SELECT COUNT(customerNumber)
    INTO total
    FROM customers
    WHERE city = input;
END
// DELIMITER ;
call GetCustomersCountByCity('Las Vegas', @total);
SELECT @total;