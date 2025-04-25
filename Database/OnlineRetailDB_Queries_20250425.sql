-- Basic SQL Queries (1-10)
-- 1. List all available products in stock
SELECT * FROM Product;
-- 2. Show name and email of all customers
SELECT customerName, email FROM Customer;
-- 3. Get orders placed in January 2023
SELECT * FROM OrderInfo WHERE orderDate BETWEEN '2023-01-01' AND '2023-01-31';
-- 4. Find products with price over 500
SELECT * FROM Product WHERE price > 500;
-- 5. List orders with status 'Completed'
SELECT * FROM OrderInfo WHERE status = 'Completed';
-- 6. Find customers registered after 2022-06-01
SELECT * FROM Customer WHERE joinDate > '2022-06-01';
-- 7. Get product count in each category
SELECT category, COUNT(*) AS product_count FROM Product GROUP BY category;
-- 8. Total products in stock
SELECT SUM(stock) AS total_stock FROM Product;
-- 9. Show product names and prices
SELECT productName, price FROM Product;
-- 10. Find products in the 'Electronics' category
SELECT * FROM Product WHERE category = 'Electronics';

-- Medium SQL Queries (11–20)
-- 11. Get customer name and total number of orders placed
SELECT C.customerName, COUNT(O.orderId) AS total_orders FROM Customer C LEFT JOIN OrderInfo O ON C.customerId = O.customerId GROUP BY C.customerName;
-- 12. Calculate total amount for each order
SELECT OD.orderId, SUM(OD.quantity * OD.unitPrice) AS total_amount FROM OrderDetail OD GROUP BY OD.orderId;
-- 13. List orders with total amount greater than 1000
SELECT OD.orderId, SUM(OD.quantity * OD.unitPrice) AS total_amount FROM OrderDetail OD GROUP BY OD.orderId HAVING total_amount > 1000;
-- 14. Find customers who have never placed an order
SELECT C.customerName FROM Customer C LEFT JOIN OrderInfo O ON C.customerId = O.customerId WHERE O.orderId IS NULL;
-- 15. Get list of customers who cancelled orders
SELECT DISTINCT C.customerName FROM Customer C JOIN OrderInfo O ON C.customerId = O.customerId WHERE O.status = 'Cancelled';
-- 16. Get the best-selling product (by total quantity)
SELECT P.productName, SUM(OD.quantity) AS total_sold FROM OrderDetail OD JOIN Product P ON OD.productId = P.productId GROUP BY OD.productId ORDER BY total_sold DESC LIMIT 1;
-- 17. Show products that have never been sold
SELECT P.productName FROM Product P LEFT JOIN OrderDetail OD ON P.productId = OD.productId WHERE OD.orderId IS NULL;
-- 18. Get orders that include product named "Wireless Mouse"
SELECT DISTINCT O.orderId FROM OrderInfo O JOIN OrderDetail OD ON O.orderId = OD.orderId JOIN Product P ON OD.productId = P.productId WHERE P.productName = 'Wireless Mouse';
-- 19. Calculate revenue per product category
SELECT P.category, SUM(OD.quantity * OD.unitPrice) AS total_revenue FROM Product P JOIN OrderDetail OD ON P.productId = OD.productId GROUP BY P.category;
-- 20. Show order details: customer name, order date, product, quantity
SELECT C.customerName, O.orderDate, P.productName, OD.quantity FROM OrderInfo O JOIN Customer C ON O.customerId = C.customerId JOIN OrderDetail OD ON O.orderId = OD.orderId JOIN Product P ON OD.productId = P.productId;

-- Advanced and Expert Queries (21–30)
-- 21. Revenue per customer
SELECT C.customerName, SUM(OD.quantity * OD.unitPrice) AS total_spent FROM Customer C JOIN OrderInfo O ON C.customerId = O.customerId JOIN OrderDetail OD ON O.orderId = OD.orderId GROUP BY C.customerName;
-- 22. Order with the highest quantity of products
SELECT orderId, SUM(quantity) AS total_quantity FROM OrderDetail GROUP BY orderId ORDER BY total_quantity DESC LIMIT 1;

-- 23. List customers who made a purchase each month in 2023
SELECT C.customerName
FROM Customer C
WHERE NOT EXISTS (
    SELECT DISTINCT MONTHS.month_num
    FROM (
        SELECT 1 AS month_num UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6
        UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 UNION SELECT 12
    ) AS MONTHS
    WHERE MONTHS.month_num NOT IN (
        SELECT DISTINCT MONTH(O.orderDate)
        FROM OrderInfo O
        WHERE O.customerId = C.customerId AND YEAR(O.orderDate) = 2023
    )
);

-- 24. List products sold in at least 2 different orders
SELECT productId FROM OrderDetail GROUP BY productId HAVING COUNT(DISTINCT orderId) >= 2;
-- 25. Find the lowest and highest value order
SELECT orderId, SUM(quantity * unitPrice) AS total_value FROM OrderDetail GROUP BY orderId ORDER BY total_value ASC LIMIT 1;
SELECT orderId, SUM(quantity * unitPrice) AS total_value FROM OrderDetail GROUP BY orderId ORDER BY total_value DESC LIMIT 1;
-- 26. Customer who spent the most
SELECT C.customerName, SUM(OD.quantity * OD.unitPrice) AS total_spent FROM Customer C JOIN OrderInfo O ON C.customerId = O.customerId JOIN OrderDetail OD ON O.orderId = OD.orderId GROUP BY C.customerName ORDER BY total_spent DESC LIMIT 1;
-- 27. Orders with at least 2 different types of products
SELECT orderId FROM OrderDetail GROUP BY orderId HAVING COUNT(DISTINCT productId) >= 2;
-- 28. Average monthly revenue in 2023
SELECT MONTH(O.orderDate) AS month, SUM(OD.quantity * OD.unitPrice) AS monthly_revenue FROM OrderInfo O JOIN OrderDetail OD ON O.orderId = OD.orderId WHERE YEAR(O.orderDate) = 2023 GROUP BY MONTH(O.orderDate);
-- 29. Report: customer name, total orders, total spent, total quantity
SELECT C.customerName, COUNT(DISTINCT O.orderId) AS total_orders, SUM(OD.quantity * OD.unitPrice) AS total_spent, SUM(OD.quantity) AS total_quantity FROM Customer C LEFT JOIN OrderInfo O ON C.customerId = O.customerId LEFT JOIN OrderDetail OD ON O.orderId = OD.orderId GROUP BY C.customerName;
-- 30. Customers who bought all products in category 'Electronics'
SELECT C.customerName
FROM Customer C
WHERE NOT EXISTS (
    SELECT P.productId
    FROM Product P
    WHERE P.category = 'Electronics'
    AND P.productId NOT IN (
        SELECT OD.productId
        FROM OrderInfo O
        JOIN OrderDetail OD ON O.orderId = OD.orderId
        WHERE O.customerId = C.customerId
    )
);
