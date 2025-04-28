USE ecommerce_db;

-- BASIC QUERIES (1-15)

-- 1. List all users
SELECT * FROM ecommerce_db.users;

-- 2. Find names and emails of customers
SELECT first_name, last_name, phone, address FROM ecommerce_db.customers;

-- 3. Count total available products
SELECT COUNT(*) AS total_products FROM ecommerce_db.products;

-- 4. List all orders and their total amount
SELECT order_id, total_amount FROM ecommerce_db.orders;

-- 5. Find orders with status 'Pending'
SELECT * FROM ecommerce_db.orders WHERE status = 'Pending';

-- 6. Find products with price greater than 500
SELECT * FROM ecommerce_db.products WHERE price > 500;

-- 7. Count customers by city
SELECT address, COUNT(*) AS customer_count FROM ecommerce_db.customers GROUP BY address;

-- 8. List all products in category 'Electronics'
SELECT p.* FROM ecommerce_db.products p JOIN ecommerce_db.product_categories pc ON p.product_id = pc.product_id JOIN ecommerce_db.categories c ON pc.category_id = c.category_id WHERE c.name = 'Electronics';

-- 9. Show detailed order information
SELECT o.order_id, p.name, oi.quantity FROM ecommerce_db.orders o JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id JOIN ecommerce_db.products p ON oi.product_id = p.product_id;

-- 10. List all warehouses
SELECT * FROM ecommerce_db.warehouses;

-- 11. List products with stock below 20
SELECT p.product_id, p.name, i.stock_quantity FROM ecommerce_db.inventory i JOIN ecommerce_db.products p ON i.product_id = p.product_id WHERE i.stock_quantity < 20;

-- 12. Find shipping methods with cost greater than 1000
SELECT * FROM ecommerce_db.shipping_methods WHERE cost > 1000;

-- 13. List orders for customer with user_id = 5
SELECT o.* FROM ecommerce_db.orders o JOIN ecommerce_db.customers c ON o.customer_id = c.customer_id WHERE c.user_id = 5;

-- 14. Get top 10 most expensive products
SELECT * FROM ecommerce_db.products ORDER BY price DESC LIMIT 10;

-- 15. Calculate total paid for order ID = 1
SELECT SUM(amount) AS total_paid FROM ecommerce_db.payments WHERE order_id = 1;

-- INTERMEDIATE QUERIES (16-35)

-- 16. List customer names and total number of their orders
SELECT c.first_name, c.last_name, COUNT(o.order_id) AS total_orders FROM ecommerce_db.customers c LEFT JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id GROUP BY c.customer_id;

-- 17. Find products never ordered
SELECT * FROM ecommerce_db.products p WHERE p.product_id NOT IN (SELECT DISTINCT product_id FROM ecommerce_db.order_items);

-- 18. Count number of products per category
SELECT c.name, COUNT(pc.product_id) AS total_products FROM ecommerce_db.categories c JOIN ecommerce_db.product_categories pc ON c.category_id = pc.category_id GROUP BY c.category_id;

-- 19. List products from supplier with supplier_id = 3
SELECT * FROM ecommerce_db.products WHERE supplier_id = 3;

-- 20. Find orders with total_amount > 1000 and delivered
SELECT * FROM ecommerce_db.orders WHERE total_amount > 1000 AND status = 'Delivered';

-- 21. List usernames and their roles
SELECT u.username, r.role_name FROM ecommerce_db.users u JOIN ecommerce_db.user_roles ur ON u.user_id = ur.user_id JOIN ecommerce_db.roles r ON ur.role_id = r.role_id;

-- 22. Count number of users per role
SELECT r.role_name, COUNT(ur.user_id) AS total_users FROM ecommerce_db.roles r LEFT JOIN ecommerce_db.user_roles ur ON r.role_id = ur.role_id GROUP BY r.role_id;

-- 23. Find customers with no orders
SELECT * FROM ecommerce_db.customers c WHERE c.customer_id NOT IN (SELECT DISTINCT customer_id FROM ecommerce_db.orders);

-- 24. Calculate total money paid by each customer
SELECT c.first_name, c.last_name, SUM(p.amount) AS total_paid FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id JOIN ecommerce_db.payments p ON o.order_id = p.order_id GROUP BY c.customer_id;

-- 25. List customer names and products they bought
SELECT c.first_name, c.last_name, p.name FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id JOIN ecommerce_db.products p ON oi.product_id = p.product_id;

-- 26. Find products belonging to more than one category
SELECT p.name FROM ecommerce_db.products p JOIN ecommerce_db.product_categories pc ON p.product_id = pc.product_id GROUP BY p.product_id HAVING COUNT(pc.category_id) > 1;

-- 27. Show products stored in multiple warehouses
SELECT p.name FROM ecommerce_db.inventory i JOIN ecommerce_db.products p ON i.product_id = p.product_id GROUP BY p.product_id HAVING COUNT(DISTINCT i.warehouse_id) > 1;

-- 28. Show product name and stock quantity in each warehouse
SELECT p.name, w.name AS warehouse_name, i.stock_quantity FROM ecommerce_db.inventory i JOIN ecommerce_db.products p ON i.product_id = p.product_id JOIN ecommerce_db.warehouses w ON i.warehouse_id = w.warehouse_id;

-- 29. Calculate total stock value per warehouse
SELECT w.name, SUM(i.stock_quantity * p.price) AS total_stock_value FROM ecommerce_db.inventory i JOIN ecommerce_db.products p ON i.product_id = p.product_id JOIN ecommerce_db.warehouses w ON i.warehouse_id = w.warehouse_id GROUP BY w.warehouse_id;

-- 30. List orders shipped using 'Express' shipping method
SELECT o.* FROM ecommerce_db.orders o JOIN ecommerce_db.shipments s ON o.order_id = s.order_id JOIN ecommerce_db.shipping_methods sm ON s.shipping_method_id = sm.shipping_method_id WHERE sm.name = 'Express';

-- 31. Find order with the most items
SELECT o.order_id, COUNT(oi.product_id) AS total_items FROM ecommerce_db.orders o JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id GROUP BY o.order_id ORDER BY total_items DESC LIMIT 1;

-- 32. Count quantity sold per brand
SELECT b.name, SUM(oi.quantity) AS total_sold FROM ecommerce_db.products p JOIN ecommerce_db.brands b ON p.brand_id = b.brand_id JOIN ecommerce_db.order_items oi ON p.product_id = oi.product_id GROUP BY b.brand_id;

-- 33. Find best-selling products (highest quantity sold)
SELECT p.name, SUM(oi.quantity) AS total_quantity FROM ecommerce_db.products p JOIN ecommerce_db.order_items oi ON p.product_id = oi.product_id GROUP BY p.product_id ORDER BY total_quantity DESC;

-- 34. List all unpaid orders (partial payment assumed)
SELECT o.* FROM ecommerce_db.orders o LEFT JOIN (SELECT order_id, SUM(amount) AS paid FROM ecommerce_db.payments GROUP BY order_id) p ON o.order_id = p.order_id WHERE o.total_amount > IFNULL(p.paid, 0);

-- 35. Count orders and total money per order status
SELECT status, COUNT(order_id) AS total_orders, SUM(total_amount) AS total_money FROM ecommerce_db.orders GROUP BY status;

-- 36. Top 5 customers with highest spending
SELECT c.first_name, c.last_name, SUM(p.amount) AS total_spent FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id JOIN ecommerce_db.payments p ON o.order_id = p.order_id GROUP BY c.customer_id ORDER BY total_spent DESC LIMIT 5;

-- 37. Average order amount per customer
SELECT c.first_name, c.last_name, AVG(o.total_amount) AS avg_order_amount FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id GROUP BY c.customer_id;

-- 38. Products sold in all three shipping methods
SELECT DISTINCT p.name FROM ecommerce_db.products p JOIN ecommerce_db.order_items oi ON p.product_id = oi.product_id JOIN ecommerce_db.orders o ON oi.order_id = o.order_id JOIN ecommerce_db.shipments s ON o.order_id = s.order_id JOIN ecommerce_db.shipping_methods sm ON s.shipping_method_id = sm.shipping_method_id GROUP BY p.product_id HAVING COUNT(DISTINCT sm.shipping_method_id) = 3;

-- 39. Products not in inventory
SELECT * FROM ecommerce_db.products WHERE product_id NOT IN (SELECT DISTINCT product_id FROM ecommerce_db.inventory);

-- 40. Suppliers with best-selling products
SELECT s.name, SUM(oi.quantity) AS total_sold FROM ecommerce_db.suppliers s JOIN ecommerce_db.products p ON s.supplier_id = p.supplier_id JOIN ecommerce_db.order_items oi ON p.product_id = oi.product_id GROUP BY s.supplier_id ORDER BY total_sold DESC;

-- 41. Customers who placed multiple orders in a day
SELECT 
  c.first_name, 
  c.last_name, 
  DATE(o.order_date) AS order_day, 
  COUNT(o.order_id) AS total_orders
FROM ecommerce_db.customers c
JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, order_day
HAVING total_orders > 1;

-- 42. Orders where total matches sum of items
SELECT o.order_id FROM ecommerce_db.orders o JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id GROUP BY o.order_id HAVING ABS(SUM(oi.unit_price * oi.quantity) - MAX(o.total_amount)) < 0.01;

-- 43. Customer name and payment methods used
SELECT c.first_name, c.last_name, GROUP_CONCAT(DISTINCT p.payment_method) AS payment_methods FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id JOIN ecommerce_db.payments p ON o.order_id = p.order_id GROUP BY c.customer_id;

-- 44. Count products per brand and category
SELECT b.name AS brand_name, c.name AS category_name, COUNT(pc.product_id) AS total_products FROM ecommerce_db.product_categories pc JOIN ecommerce_db.products p ON pc.product_id = p.product_id JOIN ecommerce_db.brands b ON p.brand_id = b.brand_id JOIN ecommerce_db.categories c ON pc.category_id = c.category_id GROUP BY b.brand_id, c.category_id;

-- 45. Warehouses with highest inventory value
SELECT w.name, SUM(i.stock_quantity * p.price) AS inventory_value FROM ecommerce_db.warehouses w JOIN ecommerce_db.inventory i ON w.warehouse_id = i.warehouse_id JOIN ecommerce_db.products p ON i.product_id = p.product_id GROUP BY w.warehouse_id ORDER BY inventory_value DESC LIMIT 5;

-- 46. Total quantity shipped to customers last month
SELECT c.first_name, c.last_name, SUM(oi.quantity) AS total_quantity FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id WHERE MONTH(o.order_date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH) GROUP BY c.customer_id;

-- 47. Product with highest total revenue
SELECT p.name, SUM(oi.quantity * oi.unit_price) AS total_revenue FROM ecommerce_db.products p JOIN ecommerce_db.order_items oi ON p.product_id = oi.product_id GROUP BY p.product_id ORDER BY total_revenue DESC LIMIT 1;

-- 48. Orders containing products from multiple brands
SELECT o.order_id FROM ecommerce_db.orders o JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id JOIN ecommerce_db.products p ON oi.product_id = p.product_id GROUP BY o.order_id HAVING COUNT(DISTINCT p.brand_id) >= 2;

-- 49. Customers with at least one 'Delivered' order paid with PayPal
SELECT DISTINCT c.first_name, c.last_name FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id JOIN ecommerce_db.payments p ON o.order_id = p.order_id WHERE o.status = 'Delivered' AND p.payment_method = 'PayPal';

-- 50. Monthly revenue and order status statistics
SELECT YEAR(order_date) AS year, MONTH(order_date) AS month, status, COUNT(order_id) AS total_orders, SUM(total_amount) AS total_revenue FROM ecommerce_db.orders GROUP BY YEAR(order_date), MONTH(order_date), status;

-- EXPERT LEVEL QUERIES (51-70)

-- 51. Top 3 best-selling products each month
SELECT MONTH(o.order_date) AS month, p.name, SUM(oi.quantity * oi.unit_price) AS revenue FROM ecommerce_db.orders o JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id JOIN ecommerce_db.products p ON oi.product_id = p.product_id WHERE YEAR(o.order_date) = 2023 GROUP BY MONTH(o.order_date), p.product_id ORDER BY month, revenue DESC;

-- 52. Customers with above-average spending
SELECT c.first_name, c.last_name, SUM(p.amount) AS total_spent FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id JOIN ecommerce_db.payments p ON o.order_id = p.order_id GROUP BY c.customer_id HAVING total_spent > (SELECT AVG(total_amount) FROM ecommerce_db.orders);

-- 53. Products sold by more than 2 suppliers
SELECT p.name FROM ecommerce_db.products p GROUP BY p.name HAVING COUNT(DISTINCT p.supplier_id) > 2;

-- 54. Customers who bought the same product twice in 30 days
SELECT c.first_name, c.last_name FROM ecommerce_db.customers c JOIN ecommerce_db.orders o1 ON c.customer_id = o1.customer_id JOIN ecommerce_db.order_items oi1 ON o1.order_id = oi1.order_id JOIN ecommerce_db.orders o2 ON c.customer_id = o2.customer_id JOIN ecommerce_db.order_items oi2 ON o2.order_id = oi2.order_id WHERE oi1.product_id = oi2.product_id AND o1.order_id <> o2.order_id AND ABS(DATEDIFF(o1.order_date, o2.order_date)) <= 30;

-- 55. Orders where total_amount mismatch
SELECT o.order_id FROM ecommerce_db.orders o JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id GROUP BY o.order_id HAVING ABS(SUM(oi.unit_price * oi.quantity) - MAX(o.total_amount)) > 1;

-- 56. Products with declining revenue over last 3 months
SELECT 
  p.product_id,
  p.name AS product_name,
  MIN(MONTH(o1.order_date)) AS month1,
  SUM(oi1.quantity * oi1.unit_price) AS revenue_month1,
  MIN(MONTH(o2.order_date)) AS month2,
  SUM(oi2.quantity * oi2.unit_price) AS revenue_month2,
  MIN(MONTH(o3.order_date)) AS month3,
  SUM(oi3.quantity * oi3.unit_price) AS revenue_month3
FROM ecommerce_db.products p

-- Month 1
JOIN ecommerce_db.order_items oi1 ON p.product_id = oi1.product_id
JOIN ecommerce_db.orders o1 ON oi1.order_id = o1.order_id

-- Month 2
JOIN ecommerce_db.order_items oi2 ON p.product_id = oi2.product_id
JOIN ecommerce_db.orders o2 ON oi2.order_id = o2.order_id

-- Month 3
JOIN ecommerce_db.order_items oi3 ON p.product_id = oi3.product_id
JOIN ecommerce_db.orders o3 ON oi3.order_id = o3.order_id

WHERE 
  o1.order_date BETWEEN DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 3 MONTH), '%Y-%m-01') AND LAST_DAY(DATE_SUB(CURDATE(), INTERVAL 2 MONTH))
  AND o2.order_date BETWEEN DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 2 MONTH), '%Y-%m-01') AND LAST_DAY(DATE_SUB(CURDATE(), INTERVAL 1 MONTH))
  AND o3.order_date BETWEEN DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 1 MONTH), '%Y-%m-01') AND LAST_DAY(DATE_SUB(CURDATE(), INTERVAL 0 MONTH))

GROUP BY 
  p.product_id, p.name

HAVING 
  revenue_month1 > revenue_month2
  AND revenue_month2 > revenue_month3

ORDER BY p.product_id;

SELECT 
    p.product_id,
    p.name AS product_name,
    latest_sales.latest_order_date,

    -- Revenue 2 months before latest
    MONTH(DATE_SUB(latest_sales.latest_order_date, INTERVAL 2 MONTH)) AS month_minus_2,
    IFNULL(SUM(CASE WHEN 
        YEAR(o.order_date) = YEAR(DATE_SUB(latest_sales.latest_order_date, INTERVAL 2 MONTH)) 
        AND MONTH(o.order_date) = MONTH(DATE_SUB(latest_sales.latest_order_date, INTERVAL 2 MONTH))
    THEN oi.quantity * oi.unit_price ELSE 0 END), 0) AS revenue_minus_2,

    -- Revenue 1 month before latest
    MONTH(DATE_SUB(latest_sales.latest_order_date, INTERVAL 1 MONTH)) AS month_minus_1,
    IFNULL(SUM(CASE WHEN 
        YEAR(o.order_date) = YEAR(DATE_SUB(latest_sales.latest_order_date, INTERVAL 1 MONTH)) 
        AND MONTH(o.order_date) = MONTH(DATE_SUB(latest_sales.latest_order_date, INTERVAL 1 MONTH))
    THEN oi.quantity * oi.unit_price ELSE 0 END), 0) AS revenue_minus_1,

    -- Revenue in latest month
    MONTH(latest_sales.latest_order_date) AS latest_month,
    IFNULL(SUM(CASE WHEN 
        YEAR(o.order_date) = YEAR(latest_sales.latest_order_date)
        AND MONTH(o.order_date) = MONTH(latest_sales.latest_order_date)
    THEN oi.quantity * oi.unit_price ELSE 0 END), 0) AS revenue_latest

FROM ecommerce_db.products p
JOIN ecommerce_db.order_items oi ON p.product_id = oi.product_id
JOIN ecommerce_db.orders o ON oi.order_id = o.order_id
JOIN (
    SELECT 
        oi_sub.product_id,
        MAX(o_sub.order_date) AS latest_order_date
    FROM ecommerce_db.order_items oi_sub
    JOIN ecommerce_db.orders o_sub ON oi_sub.order_id = o_sub.order_id
    GROUP BY oi_sub.product_id
) latest_sales ON latest_sales.product_id = p.product_id

WHERE 
    o.order_date BETWEEN DATE_SUB(latest_sales.latest_order_date, INTERVAL 2 MONTH) 
                    AND LAST_DAY(latest_sales.latest_order_date)

GROUP BY 
    p.product_id, p.name, latest_sales.latest_order_date

HAVING 
    revenue_minus_2 > revenue_minus_1
    AND revenue_minus_1 > revenue_latest

ORDER BY 
    p.product_id;


-- 57. Orders with shipment delayed more than 5 days
SELECT o.order_id FROM ecommerce_db.orders o JOIN ecommerce_db.shipments s ON o.order_id = s.order_id WHERE DATEDIFF(s.shipped_date, o.order_date) > 5;

-- 58. Orders where paid amount not matching total
SELECT o.order_id FROM ecommerce_db.orders o LEFT JOIN (SELECT order_id, SUM(amount) AS paid FROM ecommerce_db.payments GROUP BY order_id) p ON o.order_id = p.order_id WHERE ABS(o.total_amount - IFNULL(p.paid, 0)) > 1;

-- 59. Top 5 warehouses with highest inventory value
SELECT w.name, SUM(i.stock_quantity * p.price) AS total_inventory_value FROM ecommerce_db.warehouses w JOIN ecommerce_db.inventory i ON w.warehouse_id = i.warehouse_id JOIN ecommerce_db.products p ON i.product_id = p.product_id GROUP BY w.warehouse_id ORDER BY total_inventory_value DESC LIMIT 5;

-- 60. Customers buying from at least 3 brands
SELECT c.first_name, c.last_name FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id JOIN ecommerce_db.products p ON oi.product_id = p.product_id GROUP BY c.customer_id HAVING COUNT(DISTINCT p.brand_id) >= 3;

-- 61. Customers buying from at least 3 categories in one order
SELECT o.order_id FROM ecommerce_db.orders o JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id JOIN ecommerce_db.product_categories pc ON oi.product_id = pc.product_id GROUP BY o.order_id HAVING COUNT(DISTINCT pc.category_id) >= 3;

-- 62. Customer ranking by average monthly orders
SELECT c.first_name, c.last_name, COUNT(o.order_id) / 12 AS avg_monthly_orders FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id GROUP BY c.customer_id;

-- 63. Orders containing products never sold before
SELECT 
    o.order_id,
    CONCAT(c.first_name, ' ', c.last_name) AS customer_name,
    p.name AS product_name,
    o.order_date
FROM ecommerce_db.orders o
JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id
JOIN ecommerce_db.products p ON oi.product_id = p.product_id
JOIN ecommerce_db.customers c ON o.customer_id = c.customer_id
WHERE (oi.product_id, o.order_date) IN (
    SELECT oi2.product_id, MIN(o2.order_date)
    FROM ecommerce_db.order_items oi2
    JOIN ecommerce_db.orders o2 ON oi2.order_id = o2.order_id
    GROUP BY oi2.product_id
)
ORDER BY o.order_date, o.order_id;

-- 64. Percentage of canceled or failed deliveries
SELECT (COUNT(*) / (SELECT COUNT(*) FROM ecommerce_db.orders)) * 100 AS cancel_or_fail_rate FROM ecommerce_db.orders WHERE status IN ('Canceled', 'Failed');

-- 65. Customers using PayPal more than Credit Card
SELECT c.first_name, c.last_name FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id JOIN ecommerce_db.payments p ON o.order_id = p.order_id GROUP BY c.customer_id HAVING SUM(CASE WHEN p.payment_method = 'PayPal' THEN 1 ELSE 0 END) > SUM(CASE WHEN p.payment_method = 'Credit Card' THEN 1 ELSE 0 END);

-- 66. Customer spending by product category
SELECT c.first_name, c.last_name, cat.name AS category, SUM(oi.quantity * oi.unit_price) AS total_spent FROM ecommerce_db.customers c JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id JOIN ecommerce_db.order_items oi ON o.order_id = oi.order_id JOIN ecommerce_db.product_categories pc ON oi.product_id = pc.product_id JOIN ecommerce_db.categories cat ON pc.category_id = cat.category_id GROUP BY c.customer_id, cat.category_id;
 
-- 67. Products with stock more than 80% unsold
SELECT 
  p.product_id,
  p.name,
  i.stock_quantity,
  COALESCE(SUM(oi.quantity), 0) AS total_sold,
  (i.stock_quantity / (i.stock_quantity + COALESCE(SUM(oi.quantity), 0))) * 100 AS stock_percentage
FROM ecommerce_db.products p
JOIN ecommerce_db.inventory i ON p.product_id = i.product_id
LEFT JOIN ecommerce_db.order_items oi ON p.product_id = oi.product_id
GROUP BY p.product_id
HAVING stock_percentage >= 80;

-- 68. Customers with first order in 2024 and no next order
SELECT c.first_name, c.last_name
FROM ecommerce_db.customers c
JOIN ecommerce_db.orders o ON c.customer_id = o.customer_id
WHERE YEAR(o.order_date) = 2024
GROUP BY c.customer_id
HAVING COUNT(o.order_id) = 1;

-- 69. Each product: current stock, total sold, and inventory movement
SELECT 
  p.product_id,
  p.name,
  i.stock_quantity,
  COALESCE(SUM(oi.quantity), 0) AS total_sold,
  COALESCE(SUM(sm.quantity), 0) AS inventory_moved
FROM ecommerce_db.products p
LEFT JOIN ecommerce_db.inventory i ON p.product_id = i.product_id
LEFT JOIN ecommerce_db.order_items oi ON p.product_id = oi.product_id
LEFT JOIN ecommerce_db.stock_movements sm ON p.product_id = sm.product_id
GROUP BY p.product_id;

-- 70. Products with quarterly sales growth in 2023
SELECT 
  p.product_id,
  p.name,
  QUARTER(o.order_date) AS quarter,
  SUM(oi.quantity * oi.unit_price) AS quarterly_revenue
FROM ecommerce_db.products p
JOIN ecommerce_db.order_items oi ON p.product_id = oi.product_id
JOIN ecommerce_db.orders o ON oi.order_id = o.order_id
WHERE YEAR(o.order_date) = 2023
GROUP BY p.product_id, QUARTER(o.order_date)
ORDER BY p.product_id, quarter;


